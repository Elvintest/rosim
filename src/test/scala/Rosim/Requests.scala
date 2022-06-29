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
    .post("/public/message/itsm/send")
    .formParam("name","subject")
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
//    .header("Authorization", "Bearer " + s"df6d7f6d")
    .check(status.is(200))

// url https://t-cstmr-iamservice-02.rosim.novalocal:10443
  val fileUpload: HttpRequestBuilder = http("fileUpload")
    .post("/secured/file/upload")
    .check(status.is(200))

  val getUserContact: HttpRequestBuilder = http("getUserContact")
    .get("/ros/tenant-contract/api/v1/user")
    .check(status.is(200))

  val confirmationReceiving: HttpRequestBuilder = http("confirmationReceiving")
    .post("/secured/user/messages/confirmation/documents")
    .body(StringBody("""{
  "messageIds": [
    "93e7a751-7cc5-4fc2-9f3e-9b3d703bde62"
  ],
  "esiaUserId": "1000466562",
  "contractNumber": "null",
  "contractDate": "",
  "userName": "Иванов Иван Иванович",
  "organizationName": "Иванов Иван Иванович",
  "inn": "295929833306",
  "attachment": {
    "fileLink": "fileStore/6e0b5421-e131-40cc-a527-6af4a239d1d2/ПЭП.pdf",
    "fileName": "ПЭП.pdf",
    "fileType": "ПЭП"
  }
}"""))
    .check(status.is(200))

  val getParametersApplication: HttpRequestBuilder = http("getParametersApplication")
    .get("/ros/tenant-contract/api/v1/settings")
    .check(status.is(200))

  val getDictionaryCollection: HttpRequestBuilder = http("getDictionaryCollection")
    .get("/ros/tenant-contract/api/v1/dictionary-collection")
    .check(status.is(200))

  val getPaymentInformation: HttpRequestBuilder = http("getPaymentInformation")
    .get("/ros/tenant-contract/api/v1/widget/payment")
    .check(status.is(200))

  val getPaymentCalendar: ChainBuilder = feed(Array(
    Map("from" -> s"2020-11-08", "to" -> s"2022-11-09"),
    Map("from" -> s"2020-12-12", "to" -> s"2021-11-09")
  ).circular)
    .exec(http("objectsInTreasury")
      .get("/ros/tenant-contract/api/v1/widget/payment-calendar?accrualEndDateFrom={from}&accrualEndDateTo={to}")
      .check(status.is(200)))

  val printLifeSituationOne: HttpRequestBuilder = http("printLifeSituationOne")
    .post("/tc-ufs/secured/lifeSituations/printLifeSituationOne")
    .body(StringBody("""{
  "one": {
    "type": "FL",
    "name": "",
    "document": "0007 000003",
    "fio": "Иванов Иван Иванович",
    "inn": "295929833306",
    "ogrn": "",
    "ogrnip": "",
    "kpp": "",
    "phone": "+7(904)6103001",
    "email": "ivanovii555@mail.ru",
    "address": "454007, г Челябинск, пр-кт Ленина, дом 10, кв. 10",
    "isEDM": true,
    "isTenant": true,
    "esiaUserId": "1000466562",
    "confirmationDocId": ""
  },
  "two": {
    "appealParams": {
      "appealTitle": "Выкупить земельный участок без торгов",
      "appealType": "BUY_WITHOUT_BIDDING",
      "appealDate": "2022-06-20T13:46:31.000+03:00"
    },
    "senderInfo": {
      "senderName": "Иванов Иван Иванович",
      "senderInn": "295929833306",
      "senderType": "FL"
    },
    "commonParams": {
      "rosimPart": "RI_TU_107",
      "representativeInfo": {
        "representativeFio": "Иванов Иван Иванович",
        "representativePosition": ""
      },
      "dealRegistrationInfo": {
        "isDealRegistration": false,
        "isPaperContract": false,
        "deliveryMethodReg": "",
        "deliveryMethodDoc": ""
      },
      "attachments": [],
      "comment": ""
    },
    "specialParams": {
      "statementInfo": {
        "senderAddress": "454007, г Челябинск, пр-кт Ленина, дом 10, кв. 10",
        "senderPhone": "+79046103001",
        "senderEmail": "ivanovii555@mail.ru",
        "cadastralNumber": "74:37:0209001:0410",
        "landArea": 20,
        "landAddress": "Россия, обл. Челябинская, г. Южноуральск, ул. Спортивная, д. 1",
        "purposeOfUse": "RI_LAND_TYPE_-1000",
        "objectsCadastralNumbers": [],
        "articleClose": {
          "articles": [
            "ARTICLE_1"
          ],
          "articleReason": ""
        },
        "decisionInfo": []
      }
    }
  }
}"""))
    .check(status.is(200))

  val saveEDS: HttpRequestBuilder = http("saveEDS")
    .post("/secured/lifeSituations/saveEDS")
    .body(StringBody("""{
  "one": {
    "type": "FL",
    "name": "",
    "document": "0007 000003",
    "fio": "Иванов Иван Иванович",
    "inn": "295929833306",
    "ogrn": "",
    "ogrnip": "",
    "kpp": "",
    "phone": "+7(904)6103001",
    "email": "ivanovii555@mail.ru",
    "address": "454007, г Челябинск, пр-кт Ленина, дом 10, кв. 10",
    "isEDM": true,
    "isTenant": true,
    "esiaUserId": "1000466562",
    "confirmationDocId": ""
  },
  "two": {
    "appealParams": {
      "appealTitle": "Выкупить земельный участок без торгов",
      "appealType": "BUY_WITHOUT_BIDDING",
      "appealDate": "2022-06-20T13:46:31.000+03:00"
    },
    "senderInfo": {
      "senderName": "Иванов Иван Иванович",
      "senderInn": "295929833306",
      "senderType": "FL"
    },
    "commonParams": {
      "rosimPart": "RI_TU_107",
      "representativeInfo": {
        "representativeFio": "Иванов Иван Иванович",
        "representativePosition": ""
      },
      "dealRegistrationInfo": {
        "isDealRegistration": false,
        "isPaperContract": false,
        "deliveryMethodReg": "",
        "deliveryMethodDoc": ""
      },
      "attachments": [
        {
          "fileLink": "fileStore/e33dce7b-1818-41b6-9e72-36b880ef33dd/Выкупить земельный участок без торгов.pdf",
          "fileName": "Выкупить земельный участок без торгов.pdf",
          "fileType": "Заявление"
        }
      ],
      "comment": ""
    },
    "specialParams": {
      "statementInfo": {
        "senderAddress": "454007, г Челябинск, пр-кт Ленина, дом 10, кв. 10",
        "senderPhone": "+79046103001",
        "senderEmail": "ivanovii555@mail.ru",
        "cadastralNumber": "74:37:0209001:0410",
        "landArea": "double;20.00",
        "landAddress": "Россия, обл. Челябинская, г. Южноуральск, ул. Спортивная, д. 1",
        "purposeOfUse": "RI_LAND_TYPE_-1000",
        "objectsCadastralNumbers": [],
        "articleClose": {
          "articles": [
            "ARTICLE_1"
          ],
          "articleReason": ""
        },
        "decisionInfo": []
      }
    }
  }
}"""))
    .check(status.is(200))

  val LifeSituationSend: HttpRequestBuilder = http("LifeSituationSend")
    .post("/secured/lifeSituations/send?userId=1000466562")
    .body(StringBody("""{
  "appealParams": {
    "appealTitle": "Выкупить земельный участок без торгов",
    "appealType": "BUY_WITHOUT_BIDDING",
    "appealDate": "2022-06-20T13:46:31.000+03:00"
  },
  "senderInfo": {
    "senderName": "Иванов Иван Иванович",
    "senderInn": "295929833306",
    "senderType": "FL"
  },
  "commonParams": {
    "rosimPart": "RI_TU_107",
    "representativeInfo": {
      "representativeFio": "Иванов Иван Иванович",
      "representativePosition": ""
    },
    "dealRegistrationInfo": {
      "isDealRegistration": false,
      "isPaperContract": false,
      "deliveryMethodReg": "",
      "deliveryMethodDoc": ""
    },
    "attachments": [
      {
        "fileLink": "fileStore/e33dce7b-1818-41b6-9e72-36b880ef33dd/Выкупить земельный участок без торгов.pdf",
        "fileName": "Выкупить земельный участок без торгов.pdf",
        "fileType": "Заявление"
      },
      {
        "fileLink": "fileStore/5c880b3d-a583-4f7b-a218-6de9443c38b9/ПЭП.pdf",
        "fileName": "ПЭП.pdf",
        "fileType": "ПЭП"
      }
    ],
    "comment": ""
  },
  "specialParams": {
    "statementInfo": {
      "senderAddress": "454007, г Челябинск, пр-кт Ленина, дом 10, кв. 10",
      "senderPhone": "+79046103001",
      "senderEmail": "ivanovii555@mail.ru",
      "cadastralNumber": "74:37:0209001:0410",
      "landArea": 20,
      "landAddress": "Россия, обл. Челябинская, г. Южноуральск, ул. Спортивная, д. 1",
      "purposeOfUse": "RI_LAND_TYPE_-1000",
      "objectsCadastralNumbers": [],
      "articleClose": {
        "articles": [
          "ARTICLE_1"
        ],
        "articleReason": ""
      },
      "decisionInfo": []
    }
  }
}"""))
    .check(status.is(200))

  val LifeSituationDelete: HttpRequestBuilder = http("LifeSituationDelete")
    .post("/secured/lifeSituations/deleteDraft?userId=1000466562")
    .body(StringBody("""{"appealParams":{"appealType":"BUY_WITHOUT_BIDDING"}}"""))
    .check(status.is(200))

  val getUserMessages: ChainBuilder = feed(users)
    .exec(http("getUserMessages")
      .get("/secured/user/messages/?esiaUserId={userId}&page=0&size=10000")
      .check(status.is(200)))

  val fileDownload: HttpRequestBuilder = http("fileDownload")
    .get("/public/file/download?fileLink=fileStore/89969a1f-9fd0-4862-9d8a-488f1ee381c2/ПЭП.pdf")
    .check(status.is(200))

  val getSingleMessage: HttpRequestBuilder = http("getSingleMessage")
    .get("/secured/user/messages/2fa4ddd9-220a-45fa-ac7c-d1bfde20cd31?esiaUserId=1000466562&messageType=appeal_message")
    .check(status.is(200))

  val updateStatus: HttpRequestBuilder = http("updateStatus")
    .put("/secured/user/messages/2fa4ddd9-220a-45fa-ac7c-d1bfde20cd31?interactionType=appealExtraInfo&esiaUserId=1000466562&messageType=appeal_message&statusId=19308")
    .check(status.is(200))

  val getListContracts: HttpRequestBuilder = http("getListContracts")
    .get("/ros/tenant-contract/api/v1/contract")
    .check(status.is(200))

  val getRentContract: ChainBuilder = feed(Array(
    Map("contractId" -> s"1"),
    Map("contractId" -> s"2")
  ).circular)
    .exec(http("getRentContract")
      .get("/ros/tenant-contract/api/v1/contract/{contractId}")
      .check(status.is(200)))

  val getInformationBoundDocuments: HttpRequestBuilder = http("getInformationBoundDocuments")
    .post("/secured/user/messages/documents")
    .body(StringBody("""{
  "esiaUserId": "string",
  "contractNumber": "string",
  "contractDate": "2022-06-20"
}"""))
    .check(status.is(200))

  val getListRentContracts: HttpRequestBuilder = http("getListRentContracts")
    .get("/ros/tenant-contract/api/v1/facility-rental?contractId=b68553e1-9539-11ec-8118-0050569352f5&page=0&size=200")
    .check(status.is(200))

  val getAcrualsInformation: HttpRequestBuilder = http("getAcrualsInformation")
    .get("/ros/tenant-contract/api/v1/contract/b68553e1-9539-11ec-8118-0050569352f5/accruals?sortField=date&sortDirection=DESC&page=0&size=200")
    .check(status.is(200))

  val tenantContract: HttpRequestBuilder = http("tenantContract")
    .post("/ros/tenant-contract/api/v1/receipt/form")
    .body(StringBody("""{
  "contractIds": [
    "3fa85f64-5717-4562-b3fc-2c963f66afa6"
  ]
}"""))
    .check(status.is(200))

  val getTenantPayment: HttpRequestBuilder = http("getTenantPayment")
    .get("/ros/tenant-contract/api/v1/contract/b68553e1-9539-11ec-8118-0050569352f5/payment")
    .check(status.is(200))
}


