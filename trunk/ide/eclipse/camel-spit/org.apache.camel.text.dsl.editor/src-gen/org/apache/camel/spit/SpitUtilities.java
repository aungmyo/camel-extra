package org.apache.camel.spit;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.openarchitectureware.xtext.AbstractLanguageUtilities;
import org.openarchitectureware.xtext.AbstractXtextEditorPlugin;
import org.openarchitectureware.xtext.XtextFile;
import org.openarchitectureware.xtext.parser.IXtextParser;

import org.apache.camel.spit.parser.XtextParser;

public class SpitUtilities extends AbstractLanguageUtilities {

	@Override
	protected IXtextParser internalParse(InputStream inputStream) {
		return new XtextParser(inputStream);
	}

	public String getFileExtension() {
		return "spit";
	}

	public EPackage getEPackage() {
		return org.apache.camel.spit.MetaModelRegistration.getEPackage();
	}

	List<String> r = new ArrayList<String>();
	{
		r.add("resequence");
		r.add("otherwise");
		r.add("dynamic");
		r.add("convert");
		r.add("when");
		r.add("route");
		r.add("choice");
		r.add("transformer");
		r.add("properties");
		r.add("global");
		r.add("import");
		r.add("pipeline");
		r.add("filter");
		r.add("recipients");
		r.add("interceptors");
		r.add("body");
		r.add("fault");
		r.add("header");
		r.add("from");
		r.add("with");
		r.add("bean");
		r.add("to");
		r.add("interceptor");
		r.add("splitter");
	}
	public List<String> allKeywords() {
		return r;
	}

	protected ClassLoader getClassLoader() {
		return this.getClass().getClassLoader();
	}

	public IPartitionTokenScanner getPartitionScanner() {
		return new GeneratedPartitionScanner();
	}

	@Override
	public AbstractXtextEditorPlugin getXtextEditorPlugin() {
		return SpitEditorPlugin.getDefault();
	}
	
	@Override
	public String getPackageForExtensions() {
		return "org::apache::camel::spit";
	}
	
	public XtextFile getXtextFile() {
		return MetaModelRegistration.getXtextFile();
	}
}
