<template>
	<div align="center" class="home_wrap">
		<v-container>
			<v-row>
				<main-search />
			</v-row>
		</v-container>
		<v-container>
			<tag-search-form :searchList="searchList"
							/>
		</v-container>
	</div>
</template>

<script>
import MainSearch from '@/components/mainHome/MainSearch.vue'
import TagSearchForm from '@/components/detailSearch/TagSearchForm.vue'

export default {
	name: 'MSearchPage',
	components: {
		MainSearch,
		TagSearchForm
		
	},
   props: {
		searchList: {
			type:Array
		},
		word: {
			type:String
		}
   },
};
</script>

<style scoped>
</style>