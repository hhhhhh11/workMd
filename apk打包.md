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

```
    signingConfigs {
        release {
            keyAlias 'key0'
            keyPassword 'newland'
            storeFile file("newland_keystore.jks")
            storePassword 'newland'
        }

        debug {
            keyAlias 'key0'
            keyPassword 'newland'
            storeFile file("newland_keystore.jks")
            storePassword 'newland'
        }
    }
```

