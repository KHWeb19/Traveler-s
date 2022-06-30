<template>
    <v-container>
        <table>
            <tr> <!-- 검색 날짜 -->
                <td>
                    <v-date-picker v-model="dates"
                                    :min="new Date(Date.now() - new Date().getTimezoneOffset() * 60000).toISOString().substr(0,10)" range
                                    >
                    </v-date-picker>                   
                </td>
            </tr>
        </table>
    </v-container>
</template>

<script>
export default {
    name: 'MSearchCalenderForm',
    data: () => ({
        dates: [],
    }),
    computed: {
        planDate () {
            if(this.dates.length == 2) {
                if(this.dates[0] >= this.dates[1]){
                    alert ('다시 선택하세요')
                    this.initDates()
                }
            }
            return this.dates.join(' ~ ')
        },
    },
    methods: {
        initDates() {
            return this.dates = []
        }
    }
}
</script>

<style scoped>

</style>