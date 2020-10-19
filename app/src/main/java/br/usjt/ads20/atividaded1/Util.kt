package br.usjt.ads20.atividaded1

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

object Util {
    fun drawLogo(context: Context, txt: String?): Bitmap {
        val textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        textPaint.textAlign = Paint.Align.CENTER
        textPaint.color = Color.WHITE
        val size = 50.0f
        textPaint.textSize = size
        val circlePaint = Paint()
        val cores = intArrayOf(context.resources.getColor(R.color.darkBlue, null),
                context.resources.getColor(R.color.darkGreen, null),
                context.resources.getColor(R.color.darkRed, null),
                context.resources.getColor(R.color.darkPurple, null),
                context.resources.getColor(R.color.darkOrange, null),
                context.resources.getColor(R.color.navyBlue, null))
        val cor = (1000 * Math.random()).toInt() % 6
        circlePaint.color = cores[cor]
        val w = 120 // Width of profile picture
        val h = 120 // Height of profile picture
        val bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawCircle(w / 2.toFloat(), h / 2.toFloat(), w / 2.toFloat(), circlePaint)
        canvas.drawText(txt!!, w / 2.toFloat(), h / 2 + 0.3f * size, textPaint)
        return bitmap
    }
}