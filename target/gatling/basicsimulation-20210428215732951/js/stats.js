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
        "total": "39",
        "ok": "287",
        "ko": "39"
    },
    "maxResponseTime": {
        "total": "562",
        "ok": "562",
        "ko": "271"
    },
    "meanResponseTime": {
        "total": "290",
        "ok": "425",
        "ko": "155"
    },
    "standardDeviation": {
        "total": "185",
        "ok": "138",
        "ko": "116"
    },
    "percentiles1": {
        "total": "279",
        "ok": "425",
        "ko": "155"
    },
    "percentiles2": {
        "total": "356",
        "ok": "493",
        "ko": "213"
    },
    "percentiles3": {
        "total": "521",
        "ok": "548",
        "ko": "259"
    },
    "percentiles4": {
        "total": "554",
        "ok": "559",
        "ko": "269"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 2,
    "percentage": 50
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
    "percentage": 50
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.444",
        "ok": "0.222",
        "ko": "0.222"
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
        "total": "287",
        "ok": "287",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "562",
        "ok": "562",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "425",
        "ok": "425",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "138",
        "ok": "138",
        "ko": "-"
    },
    "percentiles1": {
        "total": "425",
        "ok": "425",
        "ko": "-"
    },
    "percentiles2": {
        "total": "493",
        "ok": "493",
        "ko": "-"
    },
    "percentiles3": {
        "total": "548",
        "ok": "548",
        "ko": "-"
    },
    "percentiles4": {
        "total": "559",
        "ok": "559",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 2,
    "percentage": 100
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
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.222",
        "ok": "0.222",
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
        "total": "39",
        "ok": "-",
        "ko": "39"
    },
    "maxResponseTime": {
        "total": "271",
        "ok": "-",
        "ko": "271"
    },
    "meanResponseTime": {
        "total": "155",
        "ok": "-",
        "ko": "155"
    },
    "standardDeviation": {
        "total": "116",
        "ok": "-",
        "ko": "116"
    },
    "percentiles1": {
        "total": "155",
        "ok": "-",
        "ko": "155"
    },
    "percentiles2": {
        "total": "213",
        "ok": "-",
        "ko": "213"
    },
    "percentiles3": {
        "total": "259",
        "ok": "-",
        "ko": "259"
    },
    "percentiles4": {
        "total": "269",
        "ok": "-",
        "ko": "269"
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
        "total": "0.222",
        "ok": "-",
        "ko": "0.222"
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
