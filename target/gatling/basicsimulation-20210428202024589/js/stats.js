var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "8",
        "ok": "8",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "134",
        "ok": "134",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "423",
        "ok": "423",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "215",
        "ok": "215",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "89",
        "ok": "89",
        "ko": "-"
    },
    "percentiles1": {
        "total": "195",
        "ok": "195",
        "ko": "-"
    },
    "percentiles2": {
        "total": "237",
        "ok": "237",
        "ko": "-"
    },
    "percentiles3": {
        "total": "362",
        "ok": "362",
        "ko": "-"
    },
    "percentiles4": {
        "total": "411",
        "ok": "411",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 8,
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
        "total": "0.727",
        "ok": "0.727",
        "ko": "-"
    }
},
contents: {
"req_listcountries-5f9af": {
        type: "REQUEST",
        name: "listCountries",
path: "listCountries",
pathFormatted: "req_listcountries-5f9af",
stats: {
    "name": "listCountries",
    "numberOfRequests": {
        "total": "4",
        "ok": "4",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "134",
        "ok": "134",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "161",
        "ok": "161",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "147",
        "ok": "147",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "10",
        "ok": "10",
        "ko": "-"
    },
    "percentiles1": {
        "total": "146",
        "ok": "146",
        "ko": "-"
    },
    "percentiles2": {
        "total": "151",
        "ok": "151",
        "ko": "-"
    },
    "percentiles3": {
        "total": "159",
        "ok": "159",
        "ko": "-"
    },
    "percentiles4": {
        "total": "161",
        "ok": "161",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 4,
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
        "total": "0.364",
        "ok": "0.364",
        "ko": "-"
    }
}
    },"req_login-99dea": {
        type: "REQUEST",
        name: "Login",
path: "Login",
pathFormatted: "req_login-99dea",
stats: {
    "name": "Login",
    "numberOfRequests": {
        "total": "4",
        "ok": "4",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "228",
        "ok": "228",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "423",
        "ok": "423",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "283",
        "ok": "283",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "81",
        "ok": "81",
        "ko": "-"
    },
    "percentiles1": {
        "total": "241",
        "ok": "241",
        "ko": "-"
    },
    "percentiles2": {
        "total": "293",
        "ok": "293",
        "ko": "-"
    },
    "percentiles3": {
        "total": "397",
        "ok": "397",
        "ko": "-"
    },
    "percentiles4": {
        "total": "418",
        "ok": "418",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 4,
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
        "total": "0.364",
        "ok": "0.364",
        "ko": "-"
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
