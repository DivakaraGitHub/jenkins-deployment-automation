@Library('pipelines') _

/*
arcadiaJenkinsPipeline(appName: params.APP_NAME,appTemplate:params.APP_TEMPLATE,jenkinsProject:params.JENKINS_PROJECT,
cicdGitUrl:params.CICD_GIT_URL,appGitUrl:params.APP_GIT_URL,gitCredentials:params.GIT_CREDENTIALS,gitBranch: params.GIT_BRANCH,
customTemplateParams:params.CUSTOM_TEMPLATE_PARAMETERS,imageStreamProject:params.IMAGESTREAM_PROJECT,
devProject:params.DEV_PROJECT,testProject:params.TEST_PROJECT,testTag:params.TEST_TAG,
uatProject:params.UAT_PROJECT,uatTag:params.UAT_TAG,prodProject:params.PROD_PROJECT,prodTag:params.PROD_TAG) */


javaFullPipeline(appName: params.APP_NAME, baseImage: params.BASE_IMAGE,
                 gitBranch: params.GIT_BRANCH, gitCredentials: params.GIT_CREDENTIALS,
                 gitUrl: params.GIT_URL, buildProject: params.BUILD_PROJECT,
                 buildTag: params.BUILD_TAG, deployTag: params.DEPLOY_TAG,
                 testStrategy: params.TEST_STRATEGY, testCollectionUrl: params.TEST_COLLECTION_URL,
                 testEnvironmentDefinitionUrlForBuild: params.TEST_ENVIRONMENT_DEF_URL_FOR_BUILD,
                 uatProject: params.UAT_PROJECT, prodProject: params.PROD_PROJECT,
                 testEnvironmentDefinitionUrlForPromoted: params.TEST_ENVIRONMENT_DEF_URL_FOR_PROMOTED )
                
