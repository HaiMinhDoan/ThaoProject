<template>
    <Preloader />
    <HeaderSession />
    <template v-if="dataLoadDone">
        <section class="product-page spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="product__page__content">
                            <ShowLoader :items="films" :isMultiblePage="true" :sizeOfPage="6" :title="search_text" :isSearching="true" />
                        </div>

                    </div>
                    <SideBarLoader />
                </div>
            </div>
        </section>
    </template>
<FooterSession />

</template>

<script setup>
import Preloader from './Preloader.vue';
import HeaderSession from './HeaderSession.vue';
import ShowLoader from './ShowLoader.vue';
import FooterSession from './FooterSession.vue';
import SideBarLoader from './SideBarLoader.vue';
import { ref, onMounted } from 'vue';
import { useRoute } from "vue-router";
import { preloaderFunc, backGroundSetFunc, initNavigation, initHeroSlider, initSearchModel, filterLoader } from '../assets/js/main.js';
const route = useRoute();
const search_text = ref(route.query.search_text || '');
const dataLoadDone = ref(false);
const films = ref(undefined);
const fetchData = async () => {
    dataLoadDone.value = false;
    try {
        const response = await fetch(`http://localhost:8080/theater/film/search/${search_text.value}`);
        if (!response.ok) {
            throw new Error('Error');
        }
        const data = await response.json();
        films.value = data.data;
        console.log(data.data);
    } catch (error) {

    }
    dataLoadDone.value = true;
}

function highlightCharacters(originalString, highlightString, color) {
  // Biểu thức chính quy để tìm và tô màu các chữ cái trong highlightString
  const regex = new RegExp(`[${highlightString}]`, 'gi');
  
  // Thay thế các chữ cái khớp với span màu
  const highlightedString = originalString.replace(regex, match => `<span style="color: ${color};">${match}</span>`);
  
  return highlightedString;
}
onMounted(async () => {
    await fetchData();
    preloaderFunc();
    backGroundSetFunc();
    initSearchModel();
    filterLoader();
});
</script>

<style scoped></style>