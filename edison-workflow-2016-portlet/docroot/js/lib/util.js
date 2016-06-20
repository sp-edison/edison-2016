var consoleLog = {
  loggingLevel: { info: true, debug: true, error: true },
  setLoggingLevel : function(loggingLevelJson){
    this.loggingLevel = loggingLevelJson;
  },
  info : function (msg) {
    if(console && this.loggingLevel.info){
      console.log(msg);
    }
  },
  debug : function (msg) {
    if(console && this.loggingLevel.debug){
      console.log(msg);
    }
  },
  error : function (msg) {
    if(console && this.loggingLevel.error){
      console.log(msg);
    }
  }
};

var synchronousAjaxHelper = {
  "get": function (requestUrl, callback) {
    var resultData;
    $.ajax({
      url: requestUrl,
      async: false,
      method: 'GET',
    })
    .done(function (result) {
      resultData = result;
      if(callback){ callback(result) };
      consoleLog.debug(requestUrl + " success");
    })
    .fail(function () {
      consoleLog.debug(requestUrl + " error");
    })
    .always(function () {
      consoleLog.debug(requestUrl + " complete");
    });
    return resultData;
  },
  "post": function (requestUrl, jsonData, callback) {
    var resultData;
    $.ajax({
      url: requestUrl,
      async: false,
      data : jsonData,
      method: 'POST',
    })
    .done(function (result) {
      resultData = result;
      if(callback){ callback(result) };
      consoleLog.debug(requestUrl + " success");
    })
    .fail(function (msg) {
      consoleLog.debug(requestUrl + " fail ");
      consoleLog.debug(msg);
    }).error(function(msg){
      consoleLog.debug(requestUrl + " error ");
      consoleLog.debug(msg);
    })
    .always(function (msg) {
      consoleLog.debug(requestUrl + " complete");
      consoleLog.debug(msg);
    });
    return resultData;
  },
  "jsonPost": function (requestUrl, jsonData, callback) {
    var resultData;
    $.ajax({
      url: requestUrl,
      async: false,
      contentType: "application/json; charset=utf-8",
      data : jsonData,
      method: "POST",
      dataType: "json",
    })
    .done(function (result) {
      resultData = result;
      if(callback){ callback(result) };
      consoleLog.debug(requestUrl + " success");
    })
    .fail(function (msg) {
      consoleLog.debug(requestUrl + " fail ");
      consoleLog.debug(msg);
    }).error(function(msg){
      consoleLog.debug(requestUrl + " error ");
      consoleLog.debug(msg);
    })
    .always(function (msg) {
      consoleLog.debug(requestUrl + " complete");
      consoleLog.debug(msg);
    });
    return resultData;
  }

};

var getGUID = function () {
  function s4() {
    return Math.floor((1 + Math.random()) * 0x10000)
      .toString(16)
      .substring(1);
  }
  return s4() + s4() + '-' + s4() + '-' + s4() + '-' +
    s4() + '-' + s4() + s4() + s4();
};