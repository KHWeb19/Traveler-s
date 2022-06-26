<template>
<div class="board_wrap">
<v-container>
    <search-form :searchList="searchList"/>
</v-container>
</div>
</template>

<script>
import SearchForm from '@/components/search/SearchForm.vue'

export default {
   name: 'TagSearchPage',  
   components: {
       SearchForm
   },
   props: {
       searchList: {
           type:Array
       }
   },
   data () {
        return {
            word: ''
    }
   }
}
</script>

<style scoped>
#search {
   width: 800px;
}
</style>