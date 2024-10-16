document.addEventListener('DOMContentLoaded', () => {
    let swiper = new Swiper('.swiper', {
        direction: 'horizontal',
        loop: true,
        pagination: {
            el: '.swiper-pagination'
        },

        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev'
        }
    })
})

document.addEventListener('keydown', (event) => {
    if(event.key === 'ArrowLeft') {
        swiper.slidePrev()
    } else if(event.key === 'ArrowRight'){
        swiper.slideNext()
    }
})