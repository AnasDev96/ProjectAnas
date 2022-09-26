<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\ServCtrl;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', [ServCtrl::class, 'home']);

Route::get('/server', [ServCtrl::class, 'serverMenu'])->middleware('auth');
Route::post('/server', 'ServCtrl@login')->middleware('auth');;

Route::get('/upload', [ServCtrl::class, 'uploadMenu'])->middleware('auth');
Route::post('/upload', [ServCtrl::class, 'uploadFile'])->middleware('auth');

Route::get('/delete', [ServCtrl::class, 'deleteMenu'])->middleware('auth');
Route::post('/delete', [ServCtrl::class, 'deleteFile'])->middleware('auth');

Route::get('/download', [ServCtrl::class, 'downloadMenu'])->middleware('auth');
Route::get('/download/{file}', [ServCtrl::class, 'download'])->name('download')->middleware('auth');

require __DIR__ . '/auth.php';
Route::get('/logout', '\App\Http\Controllers\Auth\AuthenticatedSessionController@destroy');
