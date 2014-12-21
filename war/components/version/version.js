'use strict';

angular.module('cupcakeHotline.version', [
  'cupcakeHotline.version.interpolate-filter',
  'cupcakeHotline.version.version-directive'
])

.value('version', '0.1');
