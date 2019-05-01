<template>
    <div class="workouts-card" v-bind:key="item.id">
        <h3> {{ msg }} </h3>
        <pre>{{item}}</pre>
        <pre>{{item.id}}</pre>
        <header>{{ toDate(item) }}
            <div class="but">
                <!---SIIIIA--->
                <button type="submit" class="btn">Edit</button>
                <button v-on:click="$emit('del-workout', item.id)" class="btn btn-del">Delete</button>
            </div>
        </header>
        <p v-for="exercise in exercises" :key="exercise">{{"- "}}{{exercise.name}}{{" "}}({{exercise.repetitions}})</p>
    </div>
</template>

<script>
    import axios from 'axios';

    export default {
        name: "WorkoutsCard",
        props: {
            item: Array,
            exercises: Array,
        },
        methods: {
            toDate: function (item) {
                let date = String(new Date(item.timestamp * 1000)).split('GMT')[0];
                return date;
            },
            delWorkout(id) {
                alert(id);
                axios
                    .delete('http://localhost:8080/workouts/', {
                        params: {
                            workoutId: id,
                        },
                    })
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
            },
        },
    }
</script>

<style scoped>
    .workouts-card {
        background: beige;
        padding: 1rem;
        width: 40rem;
        height: auto;
        margin-top: 30px;
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

    .btn {
        background: #555;
        color: #fff;
        padding: 7px 15px;
        cursor: pointer;
        margin-left: 1rem;
    }

    .btn-del {
        background: #552c2d;
    }

    .btn:hover {
        background: #666;
    }

    .but {
        position: relative;
        display: inline;
        margin: 1rem;
    }
</style>