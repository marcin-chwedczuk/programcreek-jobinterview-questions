var uUnitAssertError = function uUnitAssertError(message) {
  this.message = message;
};

var createAssertObject = function() {
  var toStr = function(obj) {
    if (obj == null)
      return "(null)";

    if (typeof(obj) === 'object')
      return JSON.stringify(obj);

    return String(obj);
  };

  return {
    $execAssertions: 0,

    $beforeAssertion: function() {
      this.$execAssertions += 1;
    },

    equal: function(expected, actual) {
      this.$beforeAssertion();

      // NaN's are always NOT equal to each other
      if (expected !== actual && !(isNaN(expected) && isNaN(actual)) )
        throw new uUnitAssertError('Assert.equal(' + this.$execAssertions + ') failed: expected ' +
          toStr(expected) + ' actual ' + toStr(actual) + '.');
    },

    arrayEqual: function(expected, actual, elementEqComparerOpt) {
      this.$beforeAssertion();

      if (expected === actual)
        return;

      var messageHeader = 'Assert.arrayEqual(' + this.$execAssertions + ') failed: ';

      if (!expected || expected.length === undefined)
        throw new uUnitAssertError(messageHeader + '"expected" argument is not array.');

      if (!actual || actual.length === undefined)
        throw new uUnitAssertError(messageHeader + '"actual" argument is not array.');

      if (expected.length != actual.length)
        throw new uUnitAssertError(messageHeader +
          'expected array of length #' + expected.length +
          ' actual array length #' + actual.length + '.');

      var eqCmp = elementEqComparerOpt || function(left, right) {
        return left === right;
      };

      for (var i = 0; i < expected.length; i += 1) {
        if (!eqCmp(expected[i], actual[i]))
          throw new uUnitAssertError(messageHeader +
            'array differ on index #' + i + ' expected array element: ' +
            toStr(expected[i]) + ' actual: ' + toStr(actual[i]) + '.');
      }
    },

    throws: function(exceptionType, action) {
      this.$beforeAssertion();

      try {
        action();

        throw new uUnitAssertError('Assert.throws(' + this.$execAssertions + ') failed: ' +
          'Exception of type ' + exceptionType.name + ' was not thrown.');
      }
      catch(e) {
        if (e instanceof uUnitAssertError)
          throw e;

        if (!(e instanceof exceptionType))
          throw new uUnitAssertError('Assert.throws(' + this.$execAssertions + ') failed: ' +
            'Expected exception of type ' + exceptionType.name + ', but ' +
            'exception of type ' + (e.constructor.name || '#anonymous') +
            ' was thrown.');
      }
    },

    true: function(expr, messageOpt) {
      this.$beforeAssertion();

      if (!expr)
        throw new uUnitAssertError('Assert.true(' + this.$execAssertions + ') failed: ' +
          'expression is not true' + (messageOpt ? ': ' + messageOpt : '') + '.');
    },

    false: function(expr, messageOpt) {
      this.$beforeAssertion();

      if (expr)
        throw new uUnitAssertError('Assert.false(' + this.$execAssertions + ') failed: ' +
          'expression is not false' + (messageOpt ? ': ' + messageOpt : '') + '.');
    }
  };
};

var genericErrorMessage = function(e) {
  return 'unhandled exception: ' + e.message;
};

var runTest = function(testResults, testName, testFunction) {
  try {
    var assert = createAssertObject();
    testFunction(assert);
    testResults.addPassedTest();
  }
  catch(e) {
    var message = (e instanceof uUnitAssertError) ?
      e.message :
      genericErrorMessage(e);

    testResults.addFailedTest(testName, message);
  }
};

var createTestResults = function() {
  return {
    passed: 0,
    failed: 0,
    skipped: 0,
    failedTestMessages: [],

    addFailedTest: function(testName, errorMessage) {
      this.failed += 1;
      this.failedTestMessages.push({
        testName: testName,
        errorMessage: errorMessage
      });
    },

    addPassedTest: function() {
      this.passed += 1;
    },

    addSkippedTest: function() {
      this.skipped += 1;
    },

    hasSkippedTests: function() {
      return (this.skipped > 0);
    }
  };
};

var displayTestResults = function(testResults) {
  console.log('TESTS [ ' + testResults.passed + ' passed / ' +
    testResults.failed + ' failed ' +
    (testResults.hasSkippedTests() ? '/ ' + testResults.skipped + ' skipped ' : '')
    + '].');

  console.log('');

  var failed = testResults.failedTestMessages;
  if (failed.length) {
    for(var i = 0; i < failed.length; i += 1) {
      console.log(failed[i].testName + ': ' + failed[i].errorMessage);
    }

    console.log('');
    console.log('FAILED.');
  }

  else {
    console.log('OK.');
  }
};

var getTestAnnotations = function(testName) {
  var annotationsRegex = /^((?:@[a-z]+\s*)*).*$/;
  var match = annotationsRegex.exec(testName);

  if (match && match[1]) {
    var annotations = match[1].
      split(/\s+/).
      filter(function(a) { return a.length > 0; });

    return annotations;
  }
  else {
    return [];
  }
};

// return object:
// {
//  annotation1: [testName1, testName2],
//  annotation2: [testName1]
// }
var getSuitAnnotations = function(testSuite) {
  var testNames = Object.keys(testSuite);
  var result = Object.create(null);

  testNames.forEach(function(testName) {
    var annotations = getTestAnnotations(testName);
    annotations.forEach(function(annotation) {
      var a = result[annotation] = result[annotation] || [];
      a.push(testName);
    });
  });

  return result;
};

var shouldRunTest = function(testName, testFunction, annotations) {
  if (typeof(testFunction) !== 'function')
    return false;

  if (annotations['@only'] && (annotations['@only'].indexOf(testName) === (-1)))
    return false;

  return true;
};

var createSingletonSuit = function(singleTestFunction) {
  var testName = singleTestFunction.name || 'main';
  var testSuite = Object.create(null);
  testSuite[testName] = singleTestFunction;
  return testSuite;
};

exports.run = function(testSuite) {
  if (!testSuite)
    throw new TypeError('testSuite must be object');

  if (typeof(testSuite) === 'function')
    testSuite = createSingletonSuit(testSuite);

  var testResults = createTestResults();
  var annotations = getSuitAnnotations(testSuite);

  for(var testName in testSuite) {
    var testFunction = testSuite[testName];
    if (shouldRunTest(testName, testFunction, annotations)) {
      runTest(testResults, testName, testFunction);
    }
    else {
      testResults.addSkippedTest();
    }
  }

  displayTestResults(testResults);
};
