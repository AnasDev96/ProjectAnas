<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('TeacherSeance', function (Blueprint $table) {
            $table->increments('id');
            $table->foreignId("idTeacher")->references("idTeacher")->on("teacher");
            $table->foreignId("idSeance")->references("idSeance")->on("Seances")->onDelete('cascade');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('TeacherSeance');
    }
};