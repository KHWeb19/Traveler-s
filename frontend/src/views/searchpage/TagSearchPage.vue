<template>
	<div align="center" class="home_wrap">
		<v-container>
			<v-row>
				<main-search />
			</v-row>
		</v-container>
		<v-container>
			<tag-search-form :searchList="tagSearchList"
							/>
		</v-container>
	</div>
</template>

<script>
import MainSearch from '@/components/mainHome/MainSearch.vue'
import TagSearchForm from '@/components/detailSearch/TagSearchForm.vue'
import { mapActions, mapState } from 'vuex';

export default {
	name: 'MSearchPage',
	components: {
		MainSearch,
		TagSearchForm
		
	},
	data () {
		return{
			keyWord: null
		}
	},
   props: {
		word: {
			type:String
		}
   },
    methods: {
    ...mapActions(["fetchTagSearchLists"]),
   },
    computed: {
    ...mapState(["tagSearchList"])
  },
   mounted() {
	if(this.word) {
		this.$store.state.tagSearchKeyWord = this.word
	}
	this.keyWord = this.$store.state.tagSearchKeyWord
	this.fetchTagSearchLists(this.keyWord)
   }
};
</script>

<style scoped>
</style>