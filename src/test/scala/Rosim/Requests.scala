package Rosim

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder


object Requests {
  //feeders
  val users: BatchableFeederBuilder[String]#F = csv("data/users.csv").circular


  //Rosim requests
  val accessibleDatesBudjet: HttpRequestBuilder = http("accessibleDatesBudget")
    .get("/public/dashboard/objectsInBudgetDates")
    .check(status.is(200))

  val accibleDatesTurnOver: HttpRequestBuilder = http("accibleDatesTurnOver")
    .get("/public/dashboard/objectsInTurnoverDates")
    .check(status.is(200))

  val dashboardObjectsInTreasuryNoParameters: HttpRequestBuilder = http("objectsInTreasury")
    .get("/public/dashboard/objectsInTreasury")
    .check(status.is(200))

  val dashboardObjectsInTreasuryWIthParameters: ChainBuilder = feed(Array(
    Map("from" -> s"2020-11-08", "to" -> s"2022-11-09"),
    Map("from" -> s"2020-12-12", "to" -> s"2021-11-09")
  ).circular)
    .exec(http("objectsInTreasury")
      .get("/public/dashboard/objectsInTreasury?dateFrom=${from}&dateTo=${to}")
      .check(status.is(200)))


  val rentContractDates: HttpRequestBuilder = http("rentContractDates")
    .get("/public/dashboard/rentContractDates")
    .check(status.is(200))

  val privatizedObjectDates: HttpRequestBuilder = http("privatizedObjectDates")
    .get("/public/dashboard/privatizedObjectsDates")
    .check(status.is(100))

  val dashboardObjectsBudget: ChainBuilder = feed(Array(
    Map("year" -> "2019"),
    Map("year" -> "2020")
  ).circular)
    .exec(http("dashboardObjectsBudget")
      .get("/public/dashboard/objectsInBudget?year=${year}")
      .check(status.is(200)))


  val objectsInTurnover: HttpRequestBuilder = http("objectsInTurnover")
    .get("/public/dashboard/objectsInTurnover?year=2022")
    .check(status.is(200))

  val dashBoardRentContracts: HttpRequestBuilder = http("dashBoardRentContracts")
    .get("/public/dashboard/rentContracts?date=2021-11-08")
    .check(status.is(200))

  val dashboardPrivatizedObjects: HttpRequestBuilder = http("dashboardPrivatizedObjects")
    .get("/public/dashboard/privatizedObjects?year=2021")
    .check(status.is(200))

  val regionMapAggregate: HttpRequestBuilder = http("regionMapAggregate")
    .get("/public/datamart/getRegionMapAggregate")
    .check(status.is(200))

  val regionMapAggregateParameterized: ChainBuilder = feed(Array(
    Map("region" -> "RU-SA"),
  ).circular)
    .exec(http("dashboardObjectsBudget")
      .get("/public/datamart/getRegionMapAggregate/${region}")
      .check(status.is(200)))

  val districtMapAggregate: HttpRequestBuilder = http("districtMapAggregate")
    .get("/public/filter/municipalDistricts")
    .check(status.is(200))

  val npaContent: HttpRequestBuilder = http("npaContent")
    .get("/public/content/laws")
    .check(status.is(200))

  val faqContent: HttpRequestBuilder = http("faqContent")
    .get("/public/content/faq")
    .check(status.is(200))

  val sectionInfo: HttpRequestBuilder = http("sectionInfo")
    .get("/public/content/sectionInfo")
    .check(status.is(200))

  val sendMessageItsm: HttpRequestBuilder = http("sendMessageItsm")
    .post("/public/message/itsm/send").formParam("name","subject")
    .check(status.is(200))

  val sendMessageItsmFilesIncluded: HttpRequestBuilder = http("sendMessageItsmFilesIncluded")
    .post("/public/message/itsm/send").formParam("name","subject")
    .formUpload("filename","file.pdf") // Здесь в filePath указать путь (относительный) до файла, в папке data
    .check(status.is(200))

  val facilityRentalList: HttpRequestBuilder = http("facilityRentalList")
    .post("/public/datamart/facilityRental/list?sort=&page=0&size=10")
    .body(StringBody("""{
  "subjectCodes": [
    "RU-CHE"
  ],
  "types": [
    "LK_OBJECT_TYPE_LAND_PLOT"
  ],
  "categoryCode": [
    "RI_LAND_AGRICULTURAL",
    "RI_LAND_PROTECTED_TERRITORIES",
    "RI_LAND_SPECIAL_PURPOSE",
    "secretData",
    "RI_LAND_WITHOUT_CATEGORY"
  ],
  "permittedUsageFormCode": [
    "RI_LAND_TYPE_1015",
    "RI_LAND_TYPE_1011",
    "RI_LAND_TYPE_1013",
    "RI_LAND_TYPE_1003",
    "RI_LAND_TYPE_1006",
    "RI_LAND_TYPE_1002",
    "RI_LAND_TYPE_1005",
    "RI_LAND_TYPE_1001",
    "RI_LAND_TYPE_1000",
    "RI_LAND_TYPE_1007",
    "RI_LAND_TYPE_1004",
    "RI_LAND_TYPE_1010",
    "RI_LAND_TYPE_1016",
    "RI_LAND_TYPE_1008",
    "RI_LAND_TYPE_1009",
    "RI_LAND_TYPE_1012",
    "RI_LAND_TYPE_1014",
    "RI_LAND_TYPE_-1000"
  ]
}"""))
    .check(status.is(200))

  val facilityRental: HttpRequestBuilder = http("facilityRental")
    .get("/public/datamart/facilityRental?id=3246344a-d5be-473f-8021-60ef5b67c7f6")
    .check(status.is(200))

  // url другой + нужен токен наверное для этой группы
  val techNotifications: HttpRequestBuilder = http("techNotifications")
    .get("/content/secured/techNotifications/actual")
    .check(status.is(200))

  val confirmNotificationsDocuments: HttpRequestBuilder = http("confirmNotifications")
    .get("/secured/user/messages/confirmation/documents?esiaUserId=1000466580")
    .check(status.is(200))

  val countUnreadMessages: HttpRequestBuilder = http("countUnreadMessages")
    .get("/secured/user/messages/unread/count?esiaUserId=1000466580")
    .check(status.is(200))

  val userSubscriptions: ChainBuilder = feed(users)
  .exec(http("userSubscriptions")
    .get("/secured/subscriptions/user/${userId}")
    .check(status.is(200)))

  val userDrafts: ChainBuilder = feed(users)
    .exec(http("userDrafts")
      .get("/secured/lifeSituations/drafts/${userId}")
      .check(status.is(200)))


  val insertDraft: HttpRequestBuilder = http("insertDraft")
    .post("/secured/lifeSituations/saveDraft?userId=1000466580")
    .body(StringBody("""{
  "appealParams": {
    "appealType": "BUY_WITHOUT_BIDDING"
  },
  "data": {
    "juridicalName": "ОРГАНИЗАЦИЯ 2107516123",
    "ogrn": "1196658017500",
    "inn": "0000000000",
    "fullName": "Иванов Иван Иванович",
    "email": "test@test.test",
    "cadastralNumber": "74:37:0209001:0410",
    "registrationContractCode": "REGISTRATION_CONTRACT_ROSIM",
    "realEstateNumberList": [
      null
    ],
    "decisionList": [],
    "decisionData": {},
    "article": [
      {
        "value": "ARTICLE_4",
        "label": "пп. 10 п. 2 статьи 39.3 ЗК РФ Без проведения торгов осуществляется продажа земельных участков гражданам для индивидуального жилищного строительства, ведения личного подсобного хозяйства в границах населенного пункта, садоводства, гражданам или крестьянским (фермерским) хозяйствам для осуществления крестьянским (фермерским) хозяйством его деятельности в соответствии со статьей 39.18 настоящего Кодекса"
      }
    ],
    "deliveryMethod": {
      "value": "DELIVERY_2",
      "label": "Почтой"
    },
    "position": {
      "value": "POSITION_1",
      "label": "Директор"
    },
    "senderPhone": "88005553535",
    "senderAddress": "127434, Город Москва, Улица Дубки ",
    "senderEmail": "test@test.test",
    "agency": {
      "value": "RI_TU_106",
      "label": "МТУ в Республике Мордовия‚ Республике Марий Эл‚ Чувашской Республике и Пензенской области"
    },
    "totalSquare": 8,
    "address": "положениеместо",
    "permittedUsageForm": {
      "value": "RI_LAND_TYPE_1013",
      "label": "Земельные участки, занятые особо охраняемыми территориями и объектами, городскими лесами, скверами, парками, городскими садами"
    },
    "objectsMissing": true
  }
}"""))
    .check(status.is(200))
}


