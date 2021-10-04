(function ()	//< Описание основной ф-ции
{
	angular
		.module('market-front', ['ngRoute','ngStorage'])
		.config(config)
		.run(run);

	function config ($routeProvider)
	{
		$routeProvider
			.when('/store',	//< задаём адрес страницы с товарами
			{
				templateUrl: 'store/store.html',	//<	адрес страницы с товарами и…
				controller:	 'storeController'		//	…имя её контроллера
			})
			.otherwise(
			{
				redirectTo:	'/store'
			});
	}
	function run ($rootScope, $http, $localStorage)	{	}
})();

angular.module('market-front').controller('indexController',
	function ($rootScope, $scope, $http, $localStorage, $location)
{
	$scope.appTitle = 'Marketplace J7-6';
	$scope.storePageTitle = 'Каталог продуктов';
});
