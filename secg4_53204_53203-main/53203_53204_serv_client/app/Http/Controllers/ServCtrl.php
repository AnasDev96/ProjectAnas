<?php

namespace App\Http\Controllers;


use Illuminate\Support\Facades\Storage;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Webpatser\Uuid\Uuid;
use App\Models\File;
use Illuminate\Support\Facades\Crypt;
//use SoareCostin\FileVault\Facades\FileVault;
use Brainstud\FileVault\Facades\FileVault;
use Illuminate\Support\Str;
class ServCtrl extends Controller
{  
    
   /**
    * displays the "server" page where you'll later can click on diffrent actions such as upload consul download or delete
    * 
    *  
    */
   public function serverMenu()
   {
       return view('server');
   }


   /**
    * display the upload page where you can upload your files 
    */
   public function uploadMenu()
   {
       return view('upload');
   }
   /**
    * upload the file to the user folder
    */
   public function uploadFile(request $request)
   {
    
       if ($request->hasFile('file')) {
           if (!Storage::exists("public/" . Auth::user()->id)) {
               Storage::makeDirectory("public/" . Auth::user()->id);
           }
 
           $filename = Storage::putFile('public/' . Auth::user()->id, $request->file('file'));
           if ($filename) {
            FileVault::encrypt($filename);
        }
           return redirect()->back()->with('success', 'Well stored file !');
       }
       return redirect()->back()->with('error', 'No file selected !');
       
     
   }

   /**
    * display delete page where yyou can delete users files 
    */
   public function deleteMenu()
   {

       $url = Storage::Files("public/" . Auth::user()->id);

       return view('delete', ['files' => $url]);
   }

   /**
    * delete the selected file from user
    */
   public function deleteFile(request $req)
   {
       $result_explode = explode('/', $req->file);
       Storage::delete($req->file);

       return back();
   }

   /**
    * display the download page where the user can download his files
    */
   public function downloadMenu()
   {
       $url = Storage::Files("public/" . Auth::user()->id);

       return view('download', ['files' => $url]);
   }

   /**
    * dowload the selected file from user
    */
   public function download($file)
   {
    if (!Storage::has('public/' . auth()->id() . '/' . $file)) {
        abort(404);
    }

       return response()->streamDownload(function () use ($file) {
        FileVault::streamDecrypt('public/' . auth()->id() . '/' . $file);
    }, Str::replaceLast('.enc', '', $file));
   
}
       /**
     * display page where you can log in or register
     */
    public function home()
    {
        return view('home');
    }
}
