<template>
    <div class="fluid wrapper">
        <Navigation activeTab="workouts"/>
        <h3> {{ msg }} </h3>
        <div class="box">
            <workouts-card
                    v-bind:i="item"
                    v-on:del-workout="delWorkout"
                    v-on:edit-workout="editWorkout"
                    v-for="exerciseItem in items" :key="exerciseItem.id"
                    :item="exerciseItem"
                    :exercises="exerciseItem.exercises"
            ></workouts-card>
        </div>
        <div class="chart">
        </div>
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
                msg: '',
            }
        },
        methods: {
            delWorkout: function (id) {
                const x = confirm("Are you sure you want to delete?");
                if (x) {
                    axios
                        .delete('http://localhost:8080/workouts/' + String(id))
                        .then((response => {
                            if (response.status === 200) {
                                this.update();
                                this.msg = "Workout was deleted";
                            } else {
                                this.msg = "Something went wrong";
                            }
                        }))
                        .catch(error => {
                            if (error) {
                                this.update();
                                //window.location.reload(true);
                                this.msg = "Workout was deleted"
                            }
                        });
                    this.msg = '';
                }
            },
            update() {
                axios
                    .get('http://localhost:8080/workouts', {})
                    .then((response => {
                        this.items = [];
                        this.items = response.data;
                    }));
            }
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
    .box {
        /*display: inline-flex;*/
    }

    .chart {
        float: right;
    }

    .wrapper {
        height: 100vh;
        margin: auto;
        background-size: cover;
        background: rgb(0, 0, 0);
        background: rgba(0, 0, 0, 0.5) url("../assets/pic.jpg") no-repeat;
        background-position: center center;

        /* Background image is fixed in the viewport so that it doesn't move when
           the content's height is greater than the image's height */
        background-attachment: fixed;

        /* This is what makes the background image rescale based
           on the container's size */
        background-size: cover;
    }
    .box {
        /* Location of the image */
        background-image: url("../assets/pic.jpg");

        /* Background image is centered vertically and horizontally at all times */
        background-position: center center;

        /* Background image doesn't tile */
        background-repeat: no-repeat;

        /* Background image is fixed in the viewport so that it doesn't move when
           the content's height is greater than the image's height */
        background-attachment: fixed;

        /* This is what makes the background image rescale based
           on the container's size */
        background-size: cover;

        /* Set a background color that will be displayed
           while the background image is loading */
        background-color: #464646;
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
    h3 {
        margin: 1rem 0 3rem 9rem;
        color: #d30000;
        text-shadow: 2px 1px #000;;

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
