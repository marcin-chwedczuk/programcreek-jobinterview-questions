
var uUnit = require('./uUnit');

var isOperator = function(op) {
  return ['+', '-', '/', '*'].indexOf(op) !== (-1);
};

var getOperator = function(op) {
  var assertAtLeast2Args = function(stack) {
      if (stack.length < 2)
        throw new TypeError('unbalanced expression');
  };

  switch (op) {
    case '+': return function(stack) {
      assertAtLeast2Args(stack);
      return stack.push(stack.pop() + stack.pop());
    };

    case '*': return function(stack) {
      assertAtLeast2Args(stack);
      return stack.push(stack.pop() * stack.pop());
    };

    case '-': return function(stack) {
      assertAtLeast2Args(stack);
      var op1 = stack.pop();
      return stack.push(stack.pop() - op1);
    };

    case '/': return function(stack) {
      assertAtLeast2Args(stack);
      var op1 = stack.pop();
      return stack.push(stack.pop() / op1);
    };
  }
};

var compute = function(rpn) {
  if (!rpn || rpn.some(function(x) { return typeof(x) !== 'string'; }))
    throw new TypeError('invalid RPN expression.');

  var stack = [];

  for (var i = 0; i < rpn.length; i += 1) {
    if (isOperator(rpn[i])) {
      var op = getOperator(rpn[i]);
      op(stack);
    }
    else {
      var n = parseFloat(rpn[i]);
      if (!isFinite(n)) {
        throw new TypeError('invalid term: ' + rpn[i]);
      }
      else {
        stack.push(n);
      }
    }
  }

  if (stack.length !== 1)
    throw new TypeError('unbalanced expression');

  return stack.pop();
};

uUnit.run({
  'can compute complex rpn expressions': function(assert) {
    assert.equal(21, compute(['1', '2', '+', '7', '*']));
    assert.equal(30, compute(['2', '3', '5', '*', '*']));
  },

  'throws TypeError given invalid number': function(assert) {
    assert.throws(TypeError, function() {
      compute(['abc', '1', '+']);
    });
  },

  'throws TypeError given unballanced expression': function(assert) {
    assert.throws(TypeError, function() {
      compute(['1', '2']);
    });

    assert.throws(TypeError, function() {
      compute(['1', '3', '5', '+']);
    });

    assert.throws(TypeError, function() {
      compute(['1', '+']);
    });

    assert.throws(TypeError, function() {
      compute([]);
    });
  },

  'given valid RPN expression returns its value': function(assert) {
    assert.equal(3, compute(['1', '2', '+']));
    assert.equal(6, compute(['2', '3', '*']));
    assert.equal(5, compute(['8', '3', '-']));
    assert.equal(4, compute(['12', '3', '/']));
    assert.equal(101, compute(['101']));
  },

  'given null throws TypeError': function(assert) {
    assert.throws(TypeError, function() {
      compute(null);
    });
  },

  'given array that contains non strings, throws TypeError': function(assert) {
    assert.throws(TypeError, function() {
      compute(['1', null, '+']);
    });

    assert.throws(TypeError, function() {
      compute([1, '2', '+']);
    });
  }
});
