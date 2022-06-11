<template>
<v-container>
  <v-row>
    <v-col cols="12" sm="6">
      <v-menu 
      ref="menu1" 
      v-model="menu1" :close-on-content-click="false" 
      transition="scale-transition"
       offset-y
        max-width="290px"
         min-width="auto">
        <template v-slot:activator="{ on, attrs }">
          <v-text-field 
          v-model="dateFormatted" 
          label="Date" 
          hint="MM/DD/YYYY format" 
          persistent-hint
            prepend-icon="mdi-calendar" v-bind="attrs" @blur="date = parseDate(dateFormatted)" v-on="on"></v-text-field>
        </template>
        <v-date-picker v-model="dates" range></v-date-picker>

      </v-menu>
    </v-col>
  
    <v-col cols="12" sm="6">
      <v-text-field v-model="dateRangeText" label="Date range" prepend-icon="mdi-calendar" readonly></v-text-field>
    </v-col>
  </v-row>
  </v-container>
</template>

<script>
  export default {
    data: () => ({
      dates: ['2019-09-10', '2019-09-20'],
    }),
    computed: {
      dateRangeText () {
        return this.dates.join(' ~ ')
      },
    },
  }
</script>
