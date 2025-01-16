<template lang="">
    <div class="popular__product products__line">
            <div class="row">
              <div class="col-lg-8 col-md-8 col-sm-8">
                <div class="section-title">
                  <h4>{{title}}</h4>
                </div>
              </div>
              <div class="col-lg-4 col-md-4 col-sm-4">
                <div class="btn__all">
                  <a href="#" class="primary-btn">View All <span class="arrow_right"></span></a>
                </div>
              </div>
            </div>
            <div class="row">
              <div v-for="(currentItem, index) in currentItems" :key="index" class="col-lg-4 col-md-6 col-sm-6">
                <div class="product__item">
                  <div class="product__item__pic" :style="{backgroundImage: 'url(' + currentItem.image + ')'}">
                    <div :class="{'ep':currentItem.status==='Full','ep_trailer':currentItem.status==='Trailer'}">{{currentItem.status}}</div>
                    <div class="comment"><i class="fa fa-comments"></i> {{currentItem.comments.length}}</div>
                    <div class="view"><i class="fa fa-eye"></i> {{ currentItem.totalViews}}</div>
                  </div>
                  <div class="product__item__text">
                    <ul>
                      <li v-for="(genre, genreIndex) in currentItem.genres" :key="genreIndex">
                        {{ genre.name }}</li>
                    </ul>
                    <h5><a :href="`/film-details/${currentItem.id}`">
                      <span v-if="!isSearching" v-html="currentItem.title"></span>
                      <span v-if="isSearching" v-html="highlightCharacters(currentItem.title,title,'','#757565')"></span>
                    </a></h5>
                  </div>
                </div>
              </div>
            </div>
      </div>
      <div class="product__pagination" v-if="isMultiblePage">
                        <a v-for="(pageNumber,index) in parts" :class="{'current-page':(index===currentPage)}" v-on:click="changePage(index)"><span class="page-num">{{index+1}}</span></a>
                        <a v-on:click="changePage(-1)"><i class="fa fa-angle-double-right page-num"></i></a>
      </div>
</template>
<script setup>
import { ref, onMounted } from 'vue';
import { preloaderFunc, backGroundSetFunc, initNavigation, initHeroSlider, initSearchModel } from '../assets/js/main.js';
const props = defineProps({
  title: {
    type: String,
    required: true,
    default: 'Popular Shows'
  },
  items: {
    type: Array,
    required: true,
    default: () => []
  },
  isMultiblePage: {
    type: Boolean,
    required: false,
    default: false
  },
  sizeOfPage: {
    type: Number,
    required: false,
    default: 15
  },
  isSearching: {
    type: Boolean,
    required: false,
    default: false
  }
});
// console.log(props.items);
//chia nhỏ items thành danh sách các danh sách nhỏ mỗi danh sách nhỏ chưa nhiều nhất chứa 24 phim tự động
const currentPage = ref(0);
const parts = ref([]);
const currentItems = ref([]);
if (props.items && props.items.length > 0) {
  if (!props.isMultiblePage) {
    parts.value.push(props.items);
  } else {
    for (let i = 0; i < props.items.length; i += props.sizeOfPage) {
      parts.value.push(props.items.slice(i, i + props.sizeOfPage));
    }
  }
}
if (parts.value.length > 0) {
  currentItems.value = parts.value[0];
} else {
  currentItems.value = [];
}
function changePage(index) {
  if (index === -1) {
    currentPage.value = currentPage.value >= (parts.value.length - 1) ? 0 : (currentPage.value + 1);
    currentItems.value = parts.value[currentPage.value];
  } else {
    currentPage.value = index;
    currentItems.value = parts.value[index];
  }
}
function highlightCharacters(originalString, highlightString, textColor, bgColor) {
  // Biểu thức chính quy để tìm và tô màu các chữ cái trong highlightString
  const regex = new RegExp(`[${highlightString}]`, 'gi');

  // Thay thế các chữ cái khớp với span có màu text và nền, giữ nguyên định dạng chuỗi gốc
  const highlightedString = originalString.replace(regex, match => `<span style="color: ${textColor}; background-color: ${bgColor};">${match}</span>`);

  return highlightedString;
}



onMounted(() => {
});
</script>

<style scoped>
.page-num {
  cursor: pointer;
}
</style>