
var uUnit = require('./uUnit');

var remdups = function(array) {
  if (array.length < 2)
    return array.length;

  var start = 0;

  for (var i = 1; i < array.length; i += 1) {
    if (array[start] !== array[i]) {
      array[++start] = array[i];
    }
  }

  return start+1;
};

uUnit.run({
  'arrays with duplicates': function(assert) {
    var array = [1,1,2,3,3,3,4,5,7,7];
    var expected = [1,2,3,4,5,7];

    var newLength = remdups(array);
    assert.arrayEqual(expected, array.slice(0, newLength));
  },

  'boundary conditions': function(assert) {
    var newLength = remdups([]);
    assert.equal(0, newLength);

    newLength = remdups([1]);
    assert.equal(1, newLength);

    newLength = remdups([1,2]);
    assert.equal(2, newLength);

    newLength = remdups([1,1]);
    assert.equal(1, newLength);
  }
});
