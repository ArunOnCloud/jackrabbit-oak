package org.apache.jackrabbit.oak.jcr;

import org.apache.jackrabbit.test.AbstractJCRTest;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.version.Version;
import javax.jcr.version.VersionManager;

public class ReadWriteOperationTest extends AbstractJCRTest {

    public void testReadingPropertyFromTest() throws RepositoryException {
        Node n = testRootNode.addNode(nodeName1, testNodeType);
        n.addMixin(mixVersionable);
        superuser.save();
        String path = n.getPath();

        Session session = getHelper().getSuperuserSession();
        Node node=session.getNode(path);
        String propertyName="propertyOne";

        node.setProperty(propertyName,"value1");
        session.save();

        String val=(String) node.getProperty(propertyName).getString();
        System.out.println("name:" + propertyName + " ,value :"+ val);

    }

    public void testSegment(){

    }

}
