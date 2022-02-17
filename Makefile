.ONESHELL:
SHELL = /bin/bash

.PHONY: help
help:             ## Show the help.
	@echo "Usage: make <target>"
	@echo ""
	@echo "Targets:"
	@fgrep "##" Makefile | fgrep -v fgrep


.PHONY: show
show:             ## Show the current environment.
	@echo "Current environment:"
	@if [ "$(USING_POETRY)" ]; then poetry env info && exit; fi
	@echo "Running using $(ENV_PREFIX)"
	@$(ENV_PREFIX)python -V
	@$(ENV_PREFIX)python -m site

.PHONY: fmt
fmt:              ## Format code using black & isort.
	mvn formatter:format

.PHONY: lint
lint:             ## Run pep8, black, mypy linters.
	$(ENV_PREFIX)flake8 kupy/
	$(ENV_PREFIX)black -l 79 --check kupy/
	$(ENV_PREFIX)black -l 79 --check tests/
	$(ENV_PREFIX)mypy --ignore-missing-imports kupy/

.PHONY: release
release:          ## Create a new tag for release.	
	@$(ENV_PREFIX)gitchangelog > HISTORY.md
	@TAG=v$(shell cat VERSION);\
	sed -i "s=unreleased=$${TAG}=g" HISTORY.md||True;\
	git add VERSION HISTORY.md;\
	git commit -m "release: version $${TAG} 🚀";\
	echo "creating git tag : $${TAG}";\
	git tag $${TAG}; 
	@git push -u origin HEAD --tags
	@echo "Github Actions will detect the new tag and release the new version."

# Process
.PHONY: dev stage prod systest tag-stage
dev:              ## Format code using black & isort.
	mvn clean package
	java -jar target/quarkus-app/quarkus-run.jar

stage: deploystage systest

deploystage:              ## Format code using black & isort.
	@oc apply -f .openshift/dev/cm.yaml
	@oc project|grep "classic-dev"
	@mvn clean package -Dquarkus.kubernetes.deploy=true

systest:
	@oc apply -f .openshift/dev/cm.yaml
	# Wait 5 seconds
	@sleep  5
	@oc rollout status -w dc/kyd-invest

tag-stage:
	@oc project|grep "classic-dev"
	@oc apply -f .openshift/dev/cm.yaml
	@git checkout VERSION
	@
	@PRE_VERSION=$(shell mvn org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate     -Dexpression=project.version|grep -Ev '(^\[|Download\w+:)')
	read -p "Version? (provide the next x.y.z version, Current version, $${PRE_VERSION}) : " TAG ;\
	mvn versions:set -DnewVersion=$${TAG} ;\
	grep "<version>$${TAG}</version>" pom.xml ;\

	oc tag classic-dev/kyd-invest:latest classic-dev/kyd-invest:$${TAG};\
	oc set image dc/kyd-invest kyd-invest=image-registry.openshift-image-registry.svc:5000/classic-dev/kyd-invest:$${TAG} -n classic-dev;\
	echo "Release $${TAG} has been deployed successfullyto stage environment!"

prod:              ## Format code using black & isort.
	@oc project|grep "quant-invest"
	oc tag classic-dev/	
	java -jar target/quarkus-app/quarkus-run.jar
