<template>
    <v-container class="MainSearch" fluid>
        <v-row justify="space-around">
            <v-col id="colsize" cols="12" xs="12" sm="4" md="3">
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
            <v-col id="colsize" cols="12" xs="12" sm="4" md="3">
                <v-select v-model="personnel" :items="items" item-value="value" prepend-icon="mdi-bed" label="인원 선택" class="PickPeople" rounded solo>
                </v-select>
            </v-col>
            <v-col id="colsize" cols="12" xs="12" sm="4" md="3">
                <v-text-field v-model="city" class="CitySearch" prepend-icon="mdi-city-variant-outline" label="도시 입력" rounded solo
                    type="city">
                    <template #append>
                        <v-btn @click="searchPage()" type="submit" value="Subscribe">
                            검색하기
                        </v-btn>
                    </template>
                </v-text-field>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>


export default {
    name: 'MainSearch',
    props:{
        hotels:{
            type: Array
        }
    },
    component: {
    },
    data: () => ({
        dates: [],
        items: ['1', '2', '3', '4'],
        value: null,
        personnel: '',
        city:'',
        num : ''
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
        searchPage() {
            const { dates, personnel , city} = this
            const payload = { dates, personnel ,city}
            const num = this.$store.state.num++
            this.$router.push({name: 'CommonSearchPage',
                                params: { payload ,num} })
        },
        initDates() {
            return this.dates = []
        }
    },
}
</script>

<style scoped>
.MainSearch{
    margin-top: 9%;
    margin-bottom: 5%;
    margin-right: 0;
    margin-left: 0;
}
.DateSearch {
    min-width: 260px;
    max-width: 150%;
}

.PickPeople {
    min-width: 260px;
    max-width: 100%;
}

.CitySearch {
    min-width: 260px;
    max-width: 150%;
}

.v-btn {
    color: rgb(55, 55, 55);
    width: 20px;
    font-size: 5px;
}


#colsize {
    max-width: 420px;
    min-width: 380px;
}
</style>