var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "8",
        "ok": "4",
        "ko": "4"
    },
    "minResponseTime": {
        "total": "57",
        "ok": "132",
        "ko": "57"
    },
    "maxResponseTime": {
        "total": "345",
        "ok": "151",
        "ko": "345"
    },
    "meanResponseTime": {
        "total": "137",
        "ok": "144",
        "ko": "130"
    },
    "standardDeviation": {
        "total": "88",
        "ok": "8",
        "ko": "124"
    },
    "percentiles1": {
        "total": "138",
        "ok": "147",
        "ko": "58"
    },
    "percentiles2": {
        "total": "150",
        "ok": "150",
        "ko": "130"
    },
    "percentiles3": {
        "total": "277",
        "ok": "151",
        "ko": "302"
    },
    "percentiles4": {
        "total": "331",
        "ok": "151",
        "ko": "336"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 4,
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
    "count": 4,
    "percentage": 50
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.727",
        "ok": "0.364",
        "ko": "0.364"
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
        "total": "132",
        "ok": "132",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "151",
        "ok": "151",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "144",
        "ok": "144",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "8",
        "ok": "8",
        "ko": "-"
    },
    "percentiles1": {
        "total": "147",
        "ok": "147",
        "ko": "-"
    },
    "percentiles2": {
        "total": "150",
        "ok": "150",
        "ko": "-"
    },
    "percentiles3": {
        "total": "151",
        "ok": "151",
        "ko": "-"
    },
    "percentiles4": {
        "total": "151",
        "ok": "151",
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
        "ok": "0",
        "ko": "4"
    },
    "minResponseTime": {
        "total": "57",
        "ok": "-",
        "ko": "57"
    },
    "maxResponseTime": {
        "total": "345",
        "ok": "-",
        "ko": "345"
    },
    "meanResponseTime": {
        "total": "130",
        "ok": "-",
        "ko": "130"
    },
    "standardDeviation": {
        "total": "124",
        "ok": "-",
        "ko": "124"
    },
    "percentiles1": {
        "total": "58",
        "ok": "-",
        "ko": "58"
    },
    "percentiles2": {
        "total": "130",
        "ok": "-",
        "ko": "130"
    },
    "percentiles3": {
        "total": "302",
        "ok": "-",
        "ko": "302"
    },
    "percentiles4": {
        "total": "336",
        "ok": "-",
        "ko": "336"
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
    "count": 4,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.364",
        "ok": "-",
        "ko": "0.364"
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
