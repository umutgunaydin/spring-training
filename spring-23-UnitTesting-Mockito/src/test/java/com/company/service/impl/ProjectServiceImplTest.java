package com.company.service.impl;

import com.company.dto.ProjectDTO;
import com.company.entity.Project;
import com.company.mapper.ProjectMapper;
import com.company.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {
    @Mock
    ProjectRepository projectRepository;
    @Mock
    ProjectMapper projectMapper;
    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void getByProjectCode_Test(){

        //Given
        when(projectRepository.findByProjectCode(anyString())).thenReturn(new Project()); //Stubbing
        when(projectMapper.convertToDto(any(Project.class))).thenReturn(new ProjectDTO());

        //when
        ProjectDTO projectDTO=projectService.getByProjectCode(anyString());

        //then
        InOrder inOrder=inOrder(projectRepository,projectMapper);//checking order

        inOrder.verify(projectRepository).findByProjectCode(anyString());
        inOrder.verify(projectMapper).convertToDto(any(Project.class));

        assertNotNull(projectDTO);
    }

    @Test
    void getByProjectCode_ExceptionTest(){

        when(projectRepository.findByProjectCode("")).thenThrow(new NoSuchElementException("Project Not Found"));

        Throwable throwable=assertThrows(NoSuchElementException.class,() -> projectService.getByProjectCode(""));

        verify(projectRepository).findByProjectCode("");

        verify(projectMapper,never()).convertToDto(any(Project.class));

        assertEquals("Project Not Found",throwable.getMessage());

    }

}