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