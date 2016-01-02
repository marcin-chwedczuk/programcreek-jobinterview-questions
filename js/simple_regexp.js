
var uUnit = require('./uUnit');

var match = function(string, pattern) {
  var NO_MATCH = {},
      MATCH = {};

  var hasMatch = backtrackMatch(string, 0, pattern, 0);
  return (hasMatch === NO_MATCH ? false : true);

  function backtrackMatch(string, spos, pattern, ppos) {
    if (atEnd(pattern, ppos)) {
      if (atEnd(string, spos))
        return MATCH;
      else
        return NO_MATCH;
    }

    if (isStarred(pattern, ppos)) {
      var maxMatch = 0;
      while ((spos + maxMatch) < string.length && charMatch(string, spos+maxMatch, pattern, ppos))
        maxMatch++;

      while (maxMatch > -1) {
        if (backtrackMatch(string, spos+maxMatch, pattern, ppos+2) === MATCH)
          return MATCH;

        maxMatch--;
      }

      return NO_MATCH;
    }
    else if (!atEnd(string, spos)) {
      if (charMatch(string, spos, pattern, ppos)) {
        return backtrackMatch(string, spos+1, pattern, ppos+1);
      }
      else {
        return NO_MATCH;
      }
    }
    else {
      return NO_MATCH;
    }
  }

  function charMatch(string, spos, pattern, ppos) {
    return pattern[ppos] === '.' || pattern[ppos] === string[spos];
  }

  function atEnd(string, position) {
    return string.length <= position;
  }

  function isStarred(pattern, position) {
    var starPosition = position+1;

    if (starPosition < pattern.length && pattern[starPosition] === '*')
      return true;
    else {
      return false;
    }
  }
};

uUnit.run({
  'match returns true for patterns w/o special characters \
   that are identical to input string': function(assert) {
    assert.equal(true, match('', ''));
    assert.equal(true, match('foo', 'foo'));
    assert.equal(true, match('buzz', 'buzz'));
  },

  'match returns false for patterns without special characters \
  that are different from input string': function(assert) {
    assert.equal(false, match('x', ''));
    assert.equal(false, match('', 'x'));
    assert.equal(false, match('a', 'b'));
    assert.equal(false, match('aa', 'a'));
    assert.equal(false, match('a', 'aa'));
  },

  'dot (.) matches any character': function(assert) {
    assert.equal(true, match('x', '.'));
    assert.equal(false, match('', '.'));
    assert.equal(true, match('xyz', 'x.z'));
    assert.equal(true, match('ab', '..'));
  },

  'start (*) matches any number of repetitions of previous character': function(assert) {
    assert.equal(true, match('', 'a*'));
    assert.equal(true, match('a', 'a*'));
    assert.equal(true, match('aaa', 'a*'));
    assert.equal(false, match('aaab', 'a*'));
  },

  'match for complex patterns returns true if entire string matches patter': function(assert) {
    assert.equal(true, match('abbbc', '.b*c'));
    assert.equal(false, match('zbbbc', 'a.*c'));
    assert.equal(true, match('blahbluz', '.*'));
    assert.equal(true, match('fujara', '...a*r*a*'));
    assert.equal(false, match('bb332', '9*b*3*4'));
  }
});
