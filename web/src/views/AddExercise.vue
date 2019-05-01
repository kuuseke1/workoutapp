<template>

    <div class="wrapper">
        <Navigation activeTab="AddExercise"/>
        <div class="login-box">
            <div class="form">
                <form class="login-form" @submit.prevent="addExercise">
                    <h3> {{ msg }} </h3>
                    <p class="msg">Select exercise:<br></p>
                    <label>
                        <select class="form-control" name="name" v-model="name">
                            <option value="Push-ups">Push-ups</option>
                            <option value="Burpees">Burpees</option>
                            <option value="Squats">Squats</option>
                            <option value="Crunches">Crunches</option>
                            <option value="Pull-ups">Pull-ups</option>
                            <option value="Dips">Dips</option>
                        </select>
                    </label><br>
                    <p class="msg">Select repetitions:<br></p>
                    <input type="number" name="repetitions" min="1" max="500" v-model="repetitions">
                    <br>
                    <br>
                    <input type="submit" value="Add exercise" class="btn">
                    <br>

                    <p class="msg">Name: {{ name }}</p>
                    <p class="msg">Repetitions: {{ repetitions }}</p>
                    <p class="msg">Picked: {{ users }}</p>
                </form>
                <br>
                <button type="submit" @click="addWorkout">Finish Workout</button>
            </div>
        </div>
    </div>
</template>

<script>
    import axios from 'axios';
    import Navigation from '../components/Navigation.vue';

    export default {
        name: "AddExercise",
        components: {
            Navigation
        },
        data() {
            return {
                name: '',
                repetitions: '',
                msg: '',
                users: [],

            }
        },
        methods: {
            addExercise: function () {
                this.users.push({
                    name: this.name,
                    repetitions: this.repetitions || 1,
                }).then(this.msg = "Keep going :)",
                    this.name = '',
                    this.repetitions = '');

            },
            addWorkout() {
                //this.$emit('addExercise', newExercise);
                axios
                    .post('http://localhost:8080/workouts', {
                        exercises: this.users,
                        timestamp: Math.round(+new Date() / 1000),
                    })

                    .then((response => {
                        if (response.status === 200) {
                            this.msg = "Workout was added";
                        } else {
                            this.msg = "Something went wrong";
                        }
                    }))
                    .catch(error => {
                        if (error) {
                            this.msg = "We are sorry, error with network/server"
                        }
                    });
                this.name = '';
                this.repetitions = '';
                this.users = [];
            },
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

    .login-box {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        width: 400px;
    }

    .form {
        position: relative;
        /*background: rgba(255, 255, 255, 0.41);*/
        background: rgba(32, 32, 32, 0.73);
        margin: 0 auto 100px;
        padding: 40px;
        text-align: center;
        /*max-width: 360px;*/
        /*box-shadow: 5px 8px 8px 5px rgba(134, 63, 76, 0.75);*/
        /*horiz, vert, blur radius, spread radius*/
        border-radius: 15px;
        /*background: #868686;*/
        border: solid rgba(255, 255, 255, 0.31);
    }

    .form .msg {
        color: rgb(162, 162, 162);
        font-size: 25px;
    }

    h3 {
        color: #a24444;
    }

    button {
        display: inline-block;
        border: solid 5px black;
        background: #555;
        color: #fff;
        padding: 7px 15px;
        cursor: pointer;
    }

    input {
        text-align: center;
        font-size: 15px;
    }

    button:hover {
        background: #666;
    }
</style>
