
var uUnit = require('./uUnit');

var atoi = function(input) {
  if (input === null)
    return NaN;

  var pos = 0,
      sign = 1,
      num = 0;

  skipWhitespace();
  if (eof())
    return NaN;

  if (['-','+'].indexOf(input[pos]) !== (-1)) {
    if (input[pos] === '-')
      sign = -1;
    pos++;
  }

  var prevPos = pos;
  while (!eof() && isDigit(input[pos])) {
    num = 10*num + (input[pos] - '0');
    pos++;
  }

  // has no digits
  if (prevPos === pos)
    return NaN;

  // has something after number
  skipWhitespace();
  if (!eof())
    return NaN;

  // return number numeric value
  return sign * num;

  function isDigit(c) {
    return ('0' <= c && c <= '9');
  }

  function eof() {
    return pos >= input.length;
  }

  function skipWhitespace() {
    while (pos < input.length && isWhitespace(input[pos]))
      pos += 1;
  }

  function isWhitespace(c) {
    return (c === ' ' || c === '\n' || c ==='\r' || c === '\t');
  }
}

uUnit.run({
  'given empty string returns NaN': function(assert) {
    assert.equal(NaN, atoi(null));
    assert.equal(NaN, atoi(''));
  },

  'given non number string returns NaN': function(assert) {
    assert.equal(NaN, atoi('abcd'));
    assert.equal(NaN, atoi('    '));
    assert.equal(NaN, atoi('32zdef'));
    assert.equal(NaN, atoi('+++'));
    assert.equal(NaN, atoi('-'));
  },

  'ignores whiespace at the begining and at the end of input': function(assert) {
    assert.equal(32, atoi('  32'));
    assert.equal(13, atoi('13  '));
    assert.equal(33, atoi(' \n33\n '));
  },

  'number can be preceded by sign (+|-)': function(assert) {
    assert.equal(32, atoi('+32'));
    assert.equal(-32, atoi('-32'));
  },

  'handles MIN/MAX integers': function(assert) {
    var MAX_INTEGER = Math.pow(2, 53);
    assert.equal(MAX_INTEGER, atoi(MAX_INTEGER.toString()));
    assert.equal(-MAX_INTEGER, atoi((-MAX_INTEGER).toString()));
  }
});
