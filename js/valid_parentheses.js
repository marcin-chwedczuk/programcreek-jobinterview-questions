
var uUnit = require('./uUnit');

var areValid = function(input) {
  var pos = 0;

  while (!eof()) {
    if (!matches()) {
      return false;
    }
  }

  return true;

  function matches() {
    // console.log(input.slice(pos));
    if (eof())
      return true;

    if (curr() != '(' && curr() != '[')
      return false;

    if (!matchParen('(', ')'))
      return false;

    if (!matchParen('[', ']'))
      return false;

    return true;

    function matchParen(parenStart, parenStop) {
      if (curr() === parenStart) {
        adv();

        while (!eof() && curr() !== parenStop) {
          if (!matches())
            return false;
        }

        if (eof()) return false;
        adv();
      }

      return true;
    }
  }

  function eof() {
    return (input === null) || (input.length <= pos);
  }

  function curr() {
    return input[pos];
  }

  function adv() {
    pos++;
  }
};

uUnit.run({
  'given valid parentheses returns true': function(assert) {
    assert.true(areValid('()'));
    assert.true(areValid('[]'));
    assert.true(areValid('()[]()'));
    assert.true(areValid('((()))'));
    assert.true(areValid('[([(())])]'));
    assert.true(areValid('[()[]]()'));
    assert.true(areValid('[()()()()]'));
  },

  'given invalid parentheses returns false': function(assert) {
    assert.false(areValid('('));
    assert.false(areValid('['));
    assert.false(areValid(']'));
    assert.false(areValid('()([])['));
    assert.false(areValid('(([))[]'));
    assert.false(areValid('[)'));
  }
});
