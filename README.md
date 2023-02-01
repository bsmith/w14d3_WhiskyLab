# WhiskyTracker

Some useful curl commands to test this:

```shell
curl http://localhost:8080/whiskies | jq
curl http://localhost:8080/distilleries | jq
curl http://localhost:8080/whiskies/find\?distillery\=The+Glenlivet\&age\=18 | jq
curl http://localhost:8080/whiskies\?year\=2014 | jq
curl http://localhost:8080/whiskies/byregion\?region\=speyside | jq
curl http://localhost:8080/distilleries/having\?age\=15 | jq
```

To load data into the application you can use something like `-DdataLoaderEnabled=true` as a VM parameter to enable the DataLoader component.