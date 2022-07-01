<!-- 다시 살리게 될 일 생길까봐 일단 삭제는 하지 않고 살려둠-->
<template>
    <v-container>
        <table style="width: 80%">
            <tr>
                <td>
                <h1 align="left">객실 소개</h1>
                </td>
                <!-- 검색창 -->
                <td align="right">
                    <v-col cols="12" xs="12" sm="6" md="4">
                    <v-menu class="menu1" :close-on-content-click="false" transition="scale-transition"
                        offset-y>
                        <template v-slot:activator="{ on, attrs }">
                            <v-text-field class="DateSearch"  label="날짜 선택" v-model="planDate"
                                prepend-icon="mdi-calendar" v-bind="attrs" v-on="on"
                                rounded solo readonly></v-text-field>
                        </template>
                        <v-date-picker v-model="dates" 
                                        :min="new Date(Date.now() - new Date().getTimezoneOffset() * 60000).toISOString().substr(0,10)" range
                                        >
                        </v-date-picker>
                    </v-menu>
                </v-col>
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