package com.example.entertainment.ModalDataimport android.media.MediaMetadataRetrieverimport com.example.entertainment.PlayerActivityimport java.util.concurrent.TimeUnitdata class Music (val id:String,val title: String,val album:String,val artist:String,val duration: Long =0, val path:String,val folderC :String, val folderIdC:String,val artUri: String)fun formatDuration(duration: Long): String {   val mitutes = TimeUnit.MINUTES.convert(duration,TimeUnit.MILLISECONDS)    val seconds = (TimeUnit.SECONDS.convert(duration,TimeUnit.MILLISECONDS)) - mitutes*TimeUnit.SECONDS.convert(1,TimeUnit.MINUTES)    return String.format("%02d:%02d",mitutes,seconds)}fun getImgArt(path: String): ByteArray? {    val retriever = MediaMetadataRetriever()    retriever.setDataSource(path)    return retriever.embeddedPicture}fun setSongPosition(increment: Boolean){    if (increment)    {        if (PlayerActivity.musicListPlayer.lastIndex == PlayerActivity.songPosition){            PlayerActivity.songPosition = 0        }else{            ++PlayerActivity.songPosition        }    }else{        if (PlayerActivity.songPosition == 0){            PlayerActivity.songPosition = PlayerActivity.musicListPlayer.lastIndex        }else{            --PlayerActivity.songPosition        }    }}