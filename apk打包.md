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
    
    signingConfigs {
        release {
            keyAlias 'newland'
            keyPassword 'IM81factory'
            storeFile file("keystore")
            storePassword 'IM81factory'
        }

        debug {
            keyAlias 'newland'
            keyPassword 'IM81factory'
            storeFile file("keystore")
            storePassword 'IM81factory'
        }
    }
    
            debug {
            keyAlias 'platform'
            keyPassword 'android'
            storeFile file("platform_userdebug.keystore")
            storePassword 'android'
        }
```

