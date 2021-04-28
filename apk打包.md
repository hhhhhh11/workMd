```
def releaseTime() {
    return new Date().format("yyyyMMdd", TimeZone.getDefault());
}

applicationVariants.all { variant ->
        variant.outputs.all {
            outputFileName = "DownloadFileTest-V${variant.versionName}-${releaseTime()}-${variant.buildType.name}.apk"
        }
    }
```

