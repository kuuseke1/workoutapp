<template>
    <div class="wrapper">
        <Navigation activeTab="workouts"/>
        <workouts-card
                v-bind:i="item"
                v-on:del-workout="delWorkout"
                v-for="exerciseItem in items" :key="exerciseItem.id"
                :item="exerciseItem"
                :exercises="exerciseItem.exercises"
        ></workouts-card>

    </div>
</template>

<script>
    import axios from 'axios';
    import Navigation from '../components/Navigation.vue';
    import WorkoutsCard from "../components/WorkoutsCard";

    export default {
        name: "Workouts",
        props: {
            item: Object
        },
        components: {
            WorkoutsCard,
            Navigation
        },
        data() {
            return {
                name: '',
                repetitions: '',
                timestamp: '',
                items: [],
            }
        },
        methods: {
            delWorkout(id) {
                const x = confirm("Are you sure you want to delete?");
                if (x) {
                    alert(id + " Heh");
                    axios
                        .delete('http://localhost:8080/workouts/' + id)
                        .catch(error => {
                            if (error) {
                                this.msg = "We are sorry, error with network/server"
                            }
                        })
                        .then((response => {
                            if (response.status === 200) {
                                this.msg = "Workout was deleted";
                            } else {
                                this.msg = "Something went wrong";
                            }
                        }));
                }
            },
        },
        mounted() {

            axios
                .get('http://localhost:8080/workouts', {})
                .then((response => {
                    this.items = [];
                    this.items = response.data;
                }));
        },
    };
</script>

<style scoped>
    .wrapper {
        height: 100vh;
        margin: auto;
        background-size: cover;
        background: rgb(0, 0, 0);
        background: rgba(0, 0, 0, 0.5) url("../assets/pic.jpg") no-repeat top;
    }


    header {
        color: #eadd23;
        background-color: rgba(255, 255, 255, 0.39);
        padding: 20px;
        font-weight: bold;

    }

    pre {
        color: #000;
    }

    p {
        color: #000;
        font-size: 20px;
        padding: 2px 20px;
    }

    #card {
        background: rgba(255, 255, 255, 0.25);
        margin: 20px 20px;
        max-width: 50%;
    }

</style>