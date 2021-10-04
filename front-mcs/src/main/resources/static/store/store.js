
angular.module('market-front').controller('storeController',
	function ($rootScope, $scope, $http, $location, $localStorage)
{

	const contextProductPath = 'http://localhost:5555/product-mcs';
	/* ^ Путь указывает на gateway-msc (указан порт gateway), но после '/' стоит название
		 модуля product-mcs.
	*/
//----------------------------------------------------------------------- методы
	$scope.loadProductsPage = function ()
	{
		$http.get (contextProductPath + '/prod')	//< /prod - суффикс в product-mcs
		.then (
		function successCallback (response)
		{
			$scope.products = response.data;
			console.log (response.data); //< в этом случае конкатенация не работает
		},
		function failureCallback (response)
		{
			alert ('\rНе удалось получить список продуктов.');
		});
	}

	$scope.infoProduct = function (p)
	{
		$http.get (contextProductPath + '/prod/' + p.productId)
		.then (
		function successCallback (response)
		{
			product = response.data;
			alert('id: '      + product.productId +
			   ',\rTitle: '   + product.title +
			   ',\rCategory: '+ product.category +
			   ',\rPrice: '   + product.price);
		},
		function failureCallback (response)
		{
			alert ('\rНе удалось получить информацию о продукте.');
		});
	}
//----------------------------------------------------------------------- вызовы
	$scope.loadProductsPage();
});
