
var uUnit = require('./uUnit');

var remdups2 = function(array) {
  if (array.length < 2)
    return array.length;

  var start = 1;

  for (var i = 2; i < array.length; i += 1) {
    if (array[start-1] !== array[i] || array[start] !== array[i]) {
      array[++start] = array[i];
    }
  }

  return start+1;
};

uUnit.run({
  'arrays with 2duplicates': function(assert) {
    var array = [1,1,2,3,3,3,4,5,7,7,7];
    var expected = [1,1,2,3,3,4,5,7,7];

    var newLength = remdups2(array);
    assert.arrayEqual(expected, array.slice(0, newLength));
  },

  'boundary conditions': function(assert) {
    var newLength = remdups2([]);
    assert.equal(0, newLength);

    newLength = remdups2([1]);
    assert.equal(1, newLength);

    newLength = remdups2([1,2]);
    assert.equal(2, newLength);

    newLength = remdups2([1,1]);
    assert.equal(2, newLength);

    newLength = remdups2([1,1,1]);
    assert.equal(2, newLength);

    newLength = remdups2([1,1,1,1]);
    assert.equal(2, newLength);
  }
});
