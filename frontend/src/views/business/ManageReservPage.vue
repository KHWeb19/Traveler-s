<template>
    <div align="center">
        <v-container>
            <tabele style="width: 100%">
                <tr>
                    <td align="left">
                <h2 class="pageTit">예약 관리</h2>
                    </td>
                </tr>

                <tr>
                    <td align="left">
                        <span class="page-count">전체</span>
                    </td>
                </tr>

                <tr>
                    <td align="center">
                      <manage-reserv-list/>
                    </td>
                </tr>

            </tabele>
        </v-container>
    </div>
</template>

<script>
import ManageReservList from '@/components/business/ManageReservList.vue'


export default {
    name: 'BManageReservPage',
    components: {
        ManageReservList

    }    
}
</script>


<style scoped>
/*table, th, td{
    border-collapse:collapse;
    border: 1px solid black;
}*/
</style>