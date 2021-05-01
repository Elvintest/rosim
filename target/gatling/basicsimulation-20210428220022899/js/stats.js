var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "4",
        "ok": "2",
        "ko": "2"
    },
    "minResponseTime": {
        "total": "379",
        "ok": "500",
        "ko": "379"
    },
    "maxResponseTime": {
        "total": "1482",
        "ok": "980",
        "ko": "1482"
    },
    "meanResponseTime": {
        "total": "835",
        "ok": "740",
        "ko": "931"
    },
    "standardDeviation": {
        "total": "436",
        "ok": "240",
        "ko": "552"
    },
    "percentiles1": {
        "total": "740",
        "ok": "740",
        "ko": "931"
    },
    "percentiles2": {
        "total": "1106",
        "ok": "860",
        "ko": "1206"
    },
    "percentiles3": {
        "total": "1407",
        "ok": "956",
        "ko": "1427"
    },
    "percentiles4": {
        "total": "1467",
        "ok": "975",
        "ko": "1471"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1,
    "percentage": 25
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1,
    "percentage": 25
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 2,
    "percentage": 50
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.4",
        "ok": "0.2",
        "ko": "0.2"
    }
},
contents: {
"req_login-99dea": {
        type: "REQUEST",
        name: "Login",
path: "Login",
pathFormatted: "req_login-99dea",
stats: {
    "name": "Login",
    "numberOfRequests": {
        "total": "2",
        "ok": "2",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "500",
        "ok": "500",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "980",
        "ok": "980",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "740",
        "ok": "740",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "240",
        "ok": "240",
        "ko": "-"
    },
    "percentiles1": {
        "total": "740",
        "ok": "740",
        "ko": "-"
    },
    "percentiles2": {
        "total": "860",
        "ok": "860",
        "ko": "-"
    },
    "percentiles3": {
        "total": "956",
        "ok": "956",
        "ko": "-"
    },
    "percentiles4": {
        "total": "975",
        "ok": "975",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1,
    "percentage": 50
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1,
    "percentage": 50
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.2",
        "ok": "0.2",
        "ko": "-"
    }
}
    },"req_userinfo-49f29": {
        type: "REQUEST",
        name: "userInfo",
path: "userInfo",
pathFormatted: "req_userinfo-49f29",
stats: {
    "name": "userInfo",
    "numberOfRequests": {
        "total": "2",
        "ok": "0",
        "ko": "2"
    },
    "minResponseTime": {
        "total": "379",
        "ok": "-",
        "ko": "379"
    },
    "maxResponseTime": {
        "total": "1482",
        "ok": "-",
        "ko": "1482"
    },
    "meanResponseTime": {
        "total": "931",
        "ok": "-",
        "ko": "931"
    },
    "standardDeviation": {
        "total": "552",
        "ok": "-",
        "ko": "552"
    },
    "percentiles1": {
        "total": "931",
        "ok": "-",
        "ko": "931"
    },
    "percentiles2": {
        "total": "1206",
        "ok": "-",
        "ko": "1206"
    },
    "percentiles3": {
        "total": "1427",
        "ok": "-",
        "ko": "1427"
    },
    "percentiles4": {
        "total": "1471",
        "ok": "-",
        "ko": "1471"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 2,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.2",
        "ok": "-",
        "ko": "0.2"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
