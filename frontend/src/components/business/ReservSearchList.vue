<template>
    
</template>


<script>
export default {
    name: 'reservSearchList',
    props: {
        searchList: {
            type: Array
        }
    },
    data() {
        return {
            keyWord: ''
        }
    },
    methods: {
        search() {
            axios.post("http://localhost:7777/reserv/search", { keyWord })
                .then((res) => {
                console.log(res.data);
                alert("검색 완료");
                this.$router.push({ name: 'reservSearchList', params: { searchList: res.data, keyWord: this.keyWord },
                    })
                    .catch(() => {});
                })
                .catch(() => {
                alert("검색 실패");
            });
        },            
    },    
}
</script>

<style scoped>

</style>