<template>
    <div class="workouts-card">
        <header>{{ toDate(item) }}</header>
        <p v-for="exercise in exercises" :key="exercise">{{"- "}}{{exercise.name}}{{" "}}({{exercise.repetitions}})</p>
    </div>
</template>

<script>
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
        },
    }
</script>

<style scoped>
    .workouts-card {
        background: beige;
        padding: 1rem;
        width: 30rem;
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
</style>