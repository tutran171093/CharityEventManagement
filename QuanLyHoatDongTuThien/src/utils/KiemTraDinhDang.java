package utils;

public class KiemTraDinhDang {

	private static final String[] tagHTML = { "<!DOCTYPE", "<a", "<abbr",
			"<acronym", "<address", "<applet", "<area", "<article",
			"<aside", "<audio", "<b", "<base", "<basefont", "<bdi",
			"<bdo", "<big", "<blockquote", "<body", "<br", "<button",
			"<canvas", "<caption", "<center", "<cite", "<code", "<col",
			"<colgroup", "<command", "<datalist", "<dd", "<del",
			"<details", "<dfn", "<dir", "<div", "<dl", "<dt", "<em",
			"<embed", "<fieldset", "<figcaption", "<figure", "<font",
			"<footer", "<form", "<frame", "<frameset", "h1", "h2", "h3",
			"h4", "h5", "h6", "<head", "<header", "<hgroup", "<hr",
			"<html", "<i", "<iframe", "<img", "<input", "<ins", "<kbd",
			"<keygen", "<label", "<legend", "<li", "<link", "<map",
			"<mark", "<menu", "<meta", "<meter", "<nav", "<noframes",
			"<noscript", "<object", "<ol", "<optgroup", "<option",
			"<output", "<output", "<param", "<pre", "<progress", "<q",
			"<rp", "<rt", "<ruby", "<s", "<samp", "<script", "<section",
			"<select", "<small", "<source", "<span", "<strike",
			"<strong", "<style", "<sub", "<summary", "<sup", "<table",
			"<tbody", "<td", "<textarea", "<tfoot", "<th", "<thead",
			"<time", "<title", "<tr", "<track", "<tt", "<u", "<ul",
			"<var", "<video", "<wbr" };

	public static boolean kiemTraPhaHoai(String noiDung) {
		for (int i = 0; i < tagHTML.length; i++) {
			if (noiDung.contains(tagHTML[i]))
				return true;
		}
		return false;
	}
	
}
