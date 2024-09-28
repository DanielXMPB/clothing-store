var snapSlider = document.getElementById('slider-round');
var snapValues = [
    document.getElementById('slider-snap-value-lower'),
    document.getElementById('slider-snap-value-upper')
];

noUiSlider.create(snapSlider, {
    start: [0, 100000],
    connect: true,
    step: 1,
    range: {
        'min': 0,
        'max': 100000
    }
});

snapSlider.noUiSlider.on('update', function (values, handle) {
    snapValues[handle].innerHTML = values[handle];
});

var app = angular.module('searchApp', []);
app.controller('searchCtrl', function ($http) {
    var app = this;
    app.clothes = [];

    app.search = function () {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/clothing-store/SvClothe',
            params: { action: 'getAllClothes' }
        }).then(function(response) {
            console.log('Success', response);
            app.clothes = response.data;
        }, function(error) {
            console.error('Error', error);
        });
    }

    app.$onInit = function () {
        app.search();
    }
})