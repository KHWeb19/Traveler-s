<template>
    <div align="center">

        <manage-reserv-list :reservs="reservs"
                                :list-array="pageArray"/>
    </div>
</template>

<script>
import ManageReservList from '@/components/business/ManageReservList.vue'


export default {
    name: 'ManageReservPage',
    components: {
        ManageReservList

    }    
}
</script>


<style scoped>

</style>