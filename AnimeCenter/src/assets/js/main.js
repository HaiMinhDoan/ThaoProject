/*  ---------------------------------------------------
    Theme Name: Anime
    Description: Anime video template
    Author: Colorlib
    Author URI: https://colorlib.com/
    Version: 1.0
    Created: Colorlib
---------------------------------------------------------  */
'use strict'
export function preloaderFunc() {
  const preloader = document.getElementById('preloader')
  if (preloader) {
    preloader.style.display = 'block'
    preloader.style.opacity = 1
    setTimeout(function () {
      preloader.style.transition = 'opacity 0.4s'
      preloader.style.opacity = 0
      setTimeout(function () {
        preloader.style.display = 'none'
      }, 400) // Thời gian trễ 400ms để phù hợp với thời gian chuyển đổi
    }, 200) // Thời gian trễ 600ms để tổng thời gian hiển thị là 3 giây (2600ms + 400ms)
  }

  // Đảm bảo preloader bị ẩn sau tối đa 3 giây nếu trang chưa tải xong
  setTimeout(function () {
    if (preloader) {
      preloader.style.transition = 'opacity 0.4s'
      preloader.style.opacity = 0
      setTimeout(function () {
        preloader.style.display = 'none'
      }, 400) // Thời gian trễ 400ms để phù hợp với thời gian chuyển đổi
    }
  }, 200) // Thời gian trễ 600ms để đảm bảo preloader bị ẩn sau tối đa 3 giây
}
export function filterLoader() {
  /*------------------
          Filter
      --------------------*/
  const filterControls = document.querySelectorAll('.filter__controls li')
  if (filterControls.length > 0) {
    filterControls.forEach(function (element) {
      element.addEventListener('click', function () {
        filterControls.forEach(function (el) {
          el.classList.remove('active')
        })
        element.classList.add('active')
      })
    })
  }

  const filterGallery = document.querySelector('.filter__gallery')
  if (filterGallery) {
    var mixer = mixitup(filterGallery)
  }
}

export function backGroundSetFunc() {
  document.querySelectorAll('.set-bg').forEach(function (element) {
    var bg = element.getAttribute('data-setbg')
    bg = '../src' + bg.substring(2)
    element.style.backgroundImage = 'url(' + bg + ')'
  })
}

export function initNavigation() {
  $('.mobile-menu').slicknav({
    prependTo: '#mobile-menu-wrap',
    allowParentLinks: true,
  })
}

export function initHeroSlider() {
  var hero_s = $('.hero__slider')
  if (hero_s.length) {
    hero_s.owlCarousel({
      loop: true,
      margin: 0,
      items: 1,
      dots: true,
      nav: true,
      navText: [
        "<span class='arrow_carrot-left'></span>",
        "<span class='arrow_carrot-right'></span>",
      ],
      animateOut: 'fadeOut',
      animateIn: 'fadeIn',
      smartSpeed: 1200,
      autoHeight: false,
      autoplay: true,
    })
  }
}

export function initSearchModel() {
  // Lấy tất cả các phần tử có class 'search-switch'
  document.querySelectorAll('.search-switch').forEach(function (element) {
    element.addEventListener('click', function () {
      // Hiển thị phần tử có class 'search-model' với hiệu ứng mượt mà
      const searchModel = document.querySelector('.search-model')
      searchModel.style.display = 'block'
      setTimeout(() => {
        searchModel.style.opacity = 1
        searchModel.style.transition = 'opacity 0.4s'
      }, 10) // Thời gian trễ nhỏ để kích hoạt hiệu ứng chuyển đổi
    })
  })

  // Lấy tất cả các phần tử có class 'search-close-switch'
  document.querySelectorAll('.search-close-switch').forEach(function (element) {
    element.addEventListener('click', function () {
      // Ẩn phần tử có class 'search-model' với hiệu ứng mượt mà
      const searchModel = document.querySelector('.search-model')
      searchModel.style.opacity = 0
      setTimeout(function () {
        searchModel.style.display = 'none'
        // Xóa giá trị của phần tử có id 'search-input'
        document.getElementById('search-input').value = ''
      }, 400) // Thời gian trễ 400ms để phù hợp với thời gian chuyển đổi
    })
  })
}
  export const player = new Plyr('#player', {
    controls: [
      'play-large',
      'play',
      'progress',
      'current-time',
      'mute',
      'captions',
      'settings',
      'fullscreen',
    ],
    seekTime: 25,
  });
